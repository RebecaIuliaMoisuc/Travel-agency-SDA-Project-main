package ro.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Airports;
public interface AirportsRepository extends JpaRepository<Airports, Integer> {
}
