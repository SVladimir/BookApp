package mk.com.iwec.BookApp.mapper;

import mk.com.iwec.BookApp.entity.City;
import mk.com.iwec.BookApp.dto.CityDto1;
import mk.com.iwec.BookApp.dto.CityDto2;
import mk.com.iwec.BookApp.infrastructure.mapper.AbstractGeneralMapper;
import mk.com.iwec.BookApp.infrastructure.mapper.GeneralMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper extends AbstractGeneralMapper implements GeneralMapper<CityDto1,CityDto2, City> {

	@Autowired
	public CityMapper(ModelMapper modelMapper) {
		super(modelMapper);
	}


	@Override
	public CityDto1 entityToDto1(City entity) {
		return this.modelMapper.map(entity, CityDto1.class);
		}


	@Override
	public City dtoToEntity1(CityDto1 dto) {
		return this.modelMapper.map(dto, City.class);
	}

	@Override
	public CityDto2 entityToDto2(City entity) {
		return this.modelMapper.map(entity, CityDto2.class);
	}

	@Override
	public City dtoToEntity2(CityDto2 dto) {
		return this.modelMapper.map(dto, City.class);
	}

	@Override
	public City entityUpdate(City updated, City original) {
			original.setPublishers(updated.getPublishers());
			original.setName(updated.getName());
			return original;
		}

}
