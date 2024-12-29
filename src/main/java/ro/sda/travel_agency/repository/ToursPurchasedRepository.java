package ro.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.entity.ToursPurchased;

public interface ToursPurchasedRepository extends JpaRepository<ToursPurchased, Integer> {
}
