package ro.sda.travel_agency.service;

import ro.sda.travel_agency.dto.CountriesDTO;
import ro.sda.travel_agency.entity.Continents;
import ro.sda.travel_agency.entity.Countries;

import java.util.List;
import java.util.Optional;

public interface CountriesService {

    Optional<Countries> findCountryById(Integer id);

    List<Countries> findAllCountries();


    void createCountry(CountriesDTO countriesDTO);

    void deleteCountryById(Integer id);
}