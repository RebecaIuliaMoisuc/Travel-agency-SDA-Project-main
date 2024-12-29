package ro.sda.travel_agency.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.travel_agency.entity.CustomerPackages;

import java.util.List;

@Repository
public interface CustomerPackagesRepository extends JpaRepository<CustomerPackages, Integer> {
    List<CustomerPackages> findByCustomer_CustomerId(int customerId);
}
