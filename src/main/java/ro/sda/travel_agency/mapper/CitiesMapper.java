package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.CitiesDTO;
import ro.sda.travel_agency.dto.CountriesDTO;
import ro.sda.travel_agency.entity.Cities;

public class CitiesMapper {

    public static CitiesDTO entityToDTO(Cities cities) {
        if (cities == null)
            return null;

        CitiesDTO citiesDTO = new CitiesDTO();
        citiesDTO.setCityId(cities.getCity_id());
        citiesDTO.setCityName(cities.getCity_name());
        citiesDTO.setCountry(CountriesMapper.entityToDTO(cities.getCountry()));
        return citiesDTO;
    }

    public static Cities dtoToEntity(CitiesDTO citiesDTO) {
        if (citiesDTO == null)
            return null;

        Cities cities=new Cities();
        cities.setCity_id(citiesDTO.getCityId());
        cities.setCity_name(citiesDTO.getCityName());
        cities.setCountry(CountriesMapper.dtoToEntity(citiesDTO.getCountry()));
        return cities;
    }

}
