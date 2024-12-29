package ro.sda.travel_agency.service;

import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.ContinentsDTO;
import ro.sda.travel_agency.entity.Cities;
import ro.sda.travel_agency.entity.Continents;

import java.util.List;
import java.util.Optional;

public interface ContinentsService {

    Optional<Continents> findContinentById(Integer id);

    List<Continents> findAllContinents();

    void createContinent(ContinentsDTO airportsDTO);

    void deleteContinentById(Integer id);
    void updateContinent(Continents continent);

}
