package mk.com.iwec.BookApp.service;

import mk.com.iwec.BookApp.entity.City;
import mk.com.iwec.BookApp.dto.CityDto2;
import mk.com.iwec.BookApp.mapper.CityMapper;
import mk.com.iwec.BookApp.repository.CityRepository;
import mk.com.iwec.BookApp.infrastructure.exception.NotFoundException;
import mk.com.iwec.BookApp.infrastructure.service.ServiceLayer;
import mk.com.iwec.BookApp.entity.Publisher;
import mk.com.iwec.BookApp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CityService implements ServiceLayer<City, CityDto2> {

	@Autowired
	CityRepository repo;
	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	CityMapper mapper;

	@Override
	public List<CityDto2> findAll() {
		return repo.findAll().stream().map(c -> {
			return mapper.entityToDto2(c);
		}).collect(Collectors.toList());
	}

	@Override
	public CityDto2 findId(Long id) {
		return mapper.entityToDto2(repo.findById(id).orElseThrow(() -> {
			return new NotFoundException("The category isn't found");
		}));
	}

	@Override
	public void deleteId(Long id) {
		repo.deleteById(id);

	}

	@Override
	public City save(City t) {
		List<Publisher> newPublishers = t.getPublishers();
		if (Objects.nonNull(newPublishers) && !newPublishers.isEmpty()) {
			newPublishers = newPublishers.stream().map(b -> {
				Publisher newPublisher = b;
				if (Objects.nonNull(b.getPublisherId())) {
					newPublisher = publisherRepository.findById(b.getPublisherId()).orElse(b);
				}
				return newPublisher;
			}).collect(Collectors.toList());
			t.setPublishers(newPublishers);
		}
		return repo.save(t);

	}

	@Override
	public City update(Long id, City t) {
		City original = repo.findById(id).orElseThrow(() -> {
			return new NotFoundException("The category is not found.");
		});
		return repo.save(mapper.entityUpdate(t, original));
	}

}