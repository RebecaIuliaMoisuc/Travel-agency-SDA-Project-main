package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.PackagesDTO;
import ro.sda.travel_agency.entity.Packages;

public class PackagesMapper {

    public static Packages dtoToEntity(PackagesDTO dto) {
        Packages packages = new Packages();
        packages.setPackageName(dto.getPackageName());
        packages.setDescription(dto.getDescription());
        packages.setPrice(dto.getPrice());
        packages.setAvailablePackages(dto.getAvailablePackages());
        // Add mappings for other fields as needed
        return packages;
    }

    public static PackagesDTO entityToDTO(Packages entity) {
        PackagesDTO dto = new PackagesDTO();
        dto.setPackageName(entity.getPackageName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setAvailablePackages(entity.getAvailablePackages());
        // Add mappings for other fields as needed
        return dto;
    }
}
