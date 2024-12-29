package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.CitiesDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Cities;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.CitiesMapper;
import ro.sda.travel_agency.repository.CitiesRepository;
import ro.sda.travel_agency.service.AirportsService;
import ro.sda.travel_agency.service.CitiesService;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesServiceImpl implements CitiesService {
    @Autowired
    CitiesRepository citiesRepository;

    @Override
    public Optional<Cities> findCityById(Integer id) {
        return citiesRepository.findById(id);
    }

    @Override
    public List<Cities> findAllCities() {
        return citiesRepository.findAll();
    }

    @Override
    public void createCity(CitiesDTO citiesDTO) {
        Cities cities = CitiesMapper.dtoToEntity(citiesDTO);
        citiesRepository.save(cities);
    }

    @Override
    public void deleteCityById(Integer id) {
        citiesRepository.deleteById(id);
    }
}