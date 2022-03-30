package mk.com.iwec.BookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto1 {
	// this class will be used for showing list of books
	private Long cityId;
	private String name;
	private List<PublisherDto1> publishers;
}
