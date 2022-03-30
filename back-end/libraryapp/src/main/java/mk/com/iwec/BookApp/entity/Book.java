package mk.com.iwec.BookApp.entity;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long bookId;

	@NonNull
	@Column(length = 200)
	private String name;

	@NonNull
	private Long edition;

	@NonNull
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Source> sources;

	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn
	private Publisher publisher;

	@ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "book_from_authors", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "ssn"))
	private List<Author> authors;

	@ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
	private List<Category> categories;

	public String toString() {

		return "Book( name=" + this.getName() + ", edition=" + this.getEdition() + ", description=" + this.getDescription() + ", sources=" + this.getSources() + ", publisher=" + this.getPublisher() + ", authors=" + this.getAuthors() + ", categories=" + this.getCategories() + ")";
	}

}