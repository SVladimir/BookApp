package mk.com.iwec.BookApp.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Source {
	@NonNull
	@Id
	@GeneratedValue
	private Long sourceId;

	private String format;

	private String url;

	private String imgSrc;

}
