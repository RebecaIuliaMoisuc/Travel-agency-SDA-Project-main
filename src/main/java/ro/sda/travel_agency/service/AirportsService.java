package ro.sda.travel_agency.service;


import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.entity.Cities;

import java.util.List;


public interface AirportsService {


    Airports findAirportById(Integer id);

    List<Airports> findAllAirports();

    void createAirport(AirportsDTO airportsDTO);

     void deleteAirportById(Integer id);
}
