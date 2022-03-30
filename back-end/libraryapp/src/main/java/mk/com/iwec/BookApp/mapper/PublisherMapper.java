package mk.com.iwec.BookApp.mapper;

import mk.com.iwec.BookApp.dto.PublisherDto1;
import mk.com.iwec.BookApp.dto.PublisherDto2;
import mk.com.iwec.BookApp.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mk.com.iwec.BookApp.infrastructure.mapper.AbstractGeneralMapper;
import mk.com.iwec.BookApp.infrastructure.mapper.GeneralMapper;

@Component
public class PublisherMapper extends AbstractGeneralMapper
		implements GeneralMapper<PublisherDto1, PublisherDto2, Publisher> {

	@Autowired
	public PublisherMapper(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public PublisherDto1 entityToDto1(Publisher entity) {
		return this.modelMapper.map(entity, PublisherDto1.class);
	}

	@Override
	public Publisher dtoToEntity1(PublisherDto1 dto) {
		return this.modelMapper.map(dto, Publisher.class);
	}

	@Override
	public PublisherDto2 entityToDto2(Publisher entity) {
		return this.modelMapper.map(entity, PublisherDto2.class);
	}

	@Override
	public Publisher dtoToEntity2(PublisherDto2 dto) {
		return this.modelMapper.map(dto, Publisher.class);
	}

	@Override
	public Publisher entityUpdate(Publisher updated, Publisher original) {
		original.setAddress(updated.getAddress());
		original.setBooks(updated.getBooks());
		original.setName(updated.getName());
		return original;
	}

}
