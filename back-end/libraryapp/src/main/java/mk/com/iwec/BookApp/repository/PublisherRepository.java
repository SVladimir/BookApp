package mk.com.iwec.BookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.com.iwec.BookApp.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}