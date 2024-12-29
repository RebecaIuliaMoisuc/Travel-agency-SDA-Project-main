package ro.sda.travel_agency.service;

import ro.sda.travel_agency.dto.CitiesDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Cities;

import java.util.List;
import java.util.Optional;

public interface CitiesService {

    Optional<Cities> findCityById(Integer id);

    List<Cities> findAllCities();

    void createCity(CitiesDTO citiesDTO);

    void deleteCityById(Integer id);

}
