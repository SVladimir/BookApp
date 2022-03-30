package mk.com.iwec.BookApp.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import mk.com.iwec.BookApp.entity.Book;
import mk.com.iwec.BookApp.entity.City;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long publisherId;

	private String name;

	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "publisher", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Book> books;

	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn
	private City city;

}
