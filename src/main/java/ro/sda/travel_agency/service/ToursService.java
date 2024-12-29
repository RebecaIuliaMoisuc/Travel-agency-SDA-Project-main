package ro.sda.travel_agency.service;

import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.ToursDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Tours;

import java.util.List;
@Service
public interface ToursService {

    Tours findToursById(Integer id);

    List<Tours> findAllTours();

    void createTour(ToursDTO toursDTO);

    void deleteTourById(Integer id);
}