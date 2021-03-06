package mk.com.iwec.BookApp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto2 {
	// this class will be shown for authors info and his books
	private String ssn;
	private String name;
	private String lastName;
	private List<BookDto3> books;

}
