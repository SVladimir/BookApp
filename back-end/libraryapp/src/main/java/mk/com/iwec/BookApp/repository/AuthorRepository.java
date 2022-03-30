package mk.com.iwec.BookApp.repository;

import mk.com.iwec.BookApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}