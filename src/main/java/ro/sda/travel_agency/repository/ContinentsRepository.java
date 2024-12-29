package ro.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Continents;


//extends the jpaRepo which contains the crud methods
//that we will use in the service
public interface ContinentsRepository  extends JpaRepository<Continents, Integer> {
}
