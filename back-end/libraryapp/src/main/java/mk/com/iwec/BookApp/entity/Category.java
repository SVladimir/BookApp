package mk.com.iwec.BookApp.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import mk.com.iwec.BookApp.entity.Book;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@NonNull
	@Id
	@GeneratedValue
	private Long categoryId;

	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "categories", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Book> books;
}
