package ro.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {
}
