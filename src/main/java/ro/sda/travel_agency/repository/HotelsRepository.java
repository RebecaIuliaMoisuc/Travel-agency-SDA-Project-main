package ro.sda.travel_agency.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Hotels;

public interface HotelsRepository extends JpaRepository<Hotels, Integer> {

}
