package mk.com.iwec.BookApp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	@Id
	@Column(length = 13, unique = true)
	@NonNull
	private String ssn;

	private String name;

	private String lastName;

	private Date birthDate;

	@JsonIgnore
	@ManyToMany(mappedBy = "authors", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Book> books;
}
