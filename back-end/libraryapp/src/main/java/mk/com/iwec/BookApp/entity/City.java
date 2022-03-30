package mk.com.iwec.BookApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {

	@Id
	@GeneratedValue
	private Long cityId;

	@NonNull
	@Column(length = 200)
	private String name;

	@OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
	private List<Publisher> publishers;

}