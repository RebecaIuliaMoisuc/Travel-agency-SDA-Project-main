package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.entity.CustomerPackages;
import ro.sda.travel_agency.repository.CustomerPackagesRepository;

import java.util.List;

@Service
public class CustomerPackagesServiceImpl {

    @Autowired
    private CustomerPackagesRepository repository;

    public List<CustomerPackages> getPackagesByCustomer(int customerId) {
        return repository.findByCustomer_CustomerId(customerId);
    }

    public CustomerPackages saveCustomerPackage(CustomerPackages customerPackage) {
        return repository.save(customerPackage);
    }
}
