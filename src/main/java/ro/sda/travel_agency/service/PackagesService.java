package ro.sda.travel_agency.service;

import ro.sda.travel_agency.dto.PackagesDTO;
import ro.sda.travel_agency.entity.Packages;

import java.util.List;

public interface PackagesService {

    Packages findPackageById(Integer id);

    List<Packages> findAllPackages();

    void createPackage(PackagesDTO packagesDTO);

    void deletePackageById(Integer id);

    Packages reservePackage(Integer packageId);

}
