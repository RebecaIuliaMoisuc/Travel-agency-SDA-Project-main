package ro.sda.travel_agency.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Countries;

public interface CountriesRepository  extends JpaRepository<Countries, Integer> {
}
