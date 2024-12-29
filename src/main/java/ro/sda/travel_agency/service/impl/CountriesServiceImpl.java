package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.CountriesDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Countries;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.CountriesMapper;
import ro.sda.travel_agency.repository.CountriesRepository;
import ro.sda.travel_agency.service.CountriesService;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesServiceImpl implements CountriesService {
    @Autowired
    CountriesRepository countriesRepository;

    @Override
    public Optional<Countries> findCountryById(Integer id) {
        return countriesRepository.findById(id);
    }

    @Override
    public List<Countries> findAllCountries() {
        return countriesRepository.findAll();
    }

    @Override
    public void createCountry(CountriesDTO countriesDTO) {
       Countries countries= CountriesMapper.dtoToEntity(countriesDTO);
        countriesRepository.save(countries);
    }

    @Override
    public void deleteCountryById(Integer id) {
        countriesRepository.deleteById(id);
    }
}