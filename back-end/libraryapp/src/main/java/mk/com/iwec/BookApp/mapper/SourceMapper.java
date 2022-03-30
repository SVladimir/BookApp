package mk.com.iwec.BookApp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mk.com.iwec.BookApp.infrastructure.mapper.AbstractGeneralMapper;
import mk.com.iwec.BookApp.entity.Source;
import mk.com.iwec.BookApp.dto.SourceDto;

@Component
public class SourceMapper extends AbstractGeneralMapper implements SourceMapperInterface<SourceDto, Source> {

	@Autowired
	public SourceMapper(ModelMapper modelMapper) {
		super(modelMapper);

	}

	@Override
	public SourceDto mapEntitytoDto(Source source) {
		return this.modelMapper.map(source, SourceDto.class);
	}

}
