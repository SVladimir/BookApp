package mk.com.iwec.BookApp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto2 {
	// this class will be used for showing individual book
	private Long bookId;
	private String name;
	private List<AuthorDto1> authors;
	private String description;
	private List<SourceDto> sources;
}
