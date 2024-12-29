package ro.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.Packages;

public interface PackagesRepository extends JpaRepository<Packages, Integer> {
}
