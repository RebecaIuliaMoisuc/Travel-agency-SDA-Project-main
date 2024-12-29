package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.PackagesDTO;
import ro.sda.travel_agency.entity.Packages;
import ro.sda.travel_agency.mapper.PackagesMapper;
import ro.sda.travel_agency.repository.PackagesRepository;
import ro.sda.travel_agency.service.PackagesService;

import java.util.List;

@Service
public class PackagesServiceImpl implements PackagesService {

    @Autowired
    private PackagesRepository packagesRepository;

    @Override
    public Packages findPackageById(Integer id) {
        return packagesRepository.findById(id).orElseThrow(() -> new RuntimeException("Package not found"));
    }

    @Override
    public List<Packages> findAllPackages() {
        return packagesRepository.findAll();
    }

    @Override
    public void createPackage(PackagesDTO packagesDTO) {
        Packages packages = PackagesMapper.dtoToEntity(packagesDTO);
        packagesRepository.save(packages);
    }

    @Override
    public void deletePackageById(Integer id) {
        packagesRepository.deleteById(id);
    }

    @Override
    public Packages reservePackage(Integer packageId) {
        Packages packages = packagesRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        if (packages.getAvailablePackages() > 0) {
            packages.setAvailablePackages(packages.getAvailablePackages() - 1);
            packagesRepository.save(packages);
        } else {
            throw new RuntimeException("No available packages left to reserve");
        }

        return packages;
    }

}
