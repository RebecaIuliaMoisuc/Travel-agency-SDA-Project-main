package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.CountriesDTO;
import ro.sda.travel_agency.entity.Countries;

public class CountriesMapper {

    public static CountriesDTO entityToDTO(Countries countries) {
        if (countries == null)
            return null;
        CountriesDTO countriesDTO = new CountriesDTO();
        countriesDTO.setCountryId(countries.getCountry_id());
        countriesDTO.setCountryName(countries.getCountry_name());
        countriesDTO.setContinent(ContinentsMapper.entityToDTO(countries.getContinent()));
        return countriesDTO;
    }

    public static Countries dtoToEntity(CountriesDTO countriesDTO) {
        if (countriesDTO == null)
            return null;

        Countries countries = new Countries();
        // Only map countryId if it's not null
        if (countriesDTO.getCountryId() != null) {
            countries.setCountry_id(countriesDTO.getCountryId());
        }
        countries.setCountry_name(countriesDTO.getCountryName());
        countries.setContinent(ContinentsMapper.dtoToEntity(countriesDTO.getContinent()));
        return countries;
    }
}
