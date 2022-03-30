package mk.com.iwec.BookApp.repository;

import mk.com.iwec.BookApp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}