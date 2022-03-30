package mk.com.iwec.BookApp.mapper;

public interface SourceMapperInterface<T, K> {
	public T mapEntitytoDto(K source);
}
