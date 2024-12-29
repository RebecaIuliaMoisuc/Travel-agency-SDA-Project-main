package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.ToursDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Tours;
import ro.sda.travel_agency.entity.ToursPurchased;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.ToursMapper;
import ro.sda.travel_agency.repository.AirportsRepository;
import ro.sda.travel_agency.repository.ToursRepository;
import ro.sda.travel_agency.service.ToursPurchasedService;
import ro.sda.travel_agency.service.ToursService;

import java.util.List;
@Service
public class ToursServiceImpl implements ToursService {
    @Autowired
    private ToursRepository toursRepository;

    @Override
    public Tours findToursById(Integer id) {
        return toursRepository.findById(id).get();
    }

    @Override
    public List<Tours> findAllTours() {
        return toursRepository.findAll();
    }

    @Override
    public void createTour(ToursDTO toursDTO) {
        Tours tour = ToursMapper.dtoToEntity(toursDTO);
        toursRepository.save(tour);
    }
    @Override
    public void deleteTourById(Integer id) {
        toursRepository.deleteById(id);
    }
}