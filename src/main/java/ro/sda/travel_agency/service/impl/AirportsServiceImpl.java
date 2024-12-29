package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Cities;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.repository.AirportsRepository;
import ro.sda.travel_agency.service.AirportsService;

import java.util.List;

@Service
public class AirportsServiceImpl implements AirportsService {

    @Autowired
    private AirportsRepository airportsRepository;


    @Override
    public Airports findAirportById(Integer id) {
        return airportsRepository.findById(id).get();
    }

    @Override
    public List<Airports> findAllAirports() {
        return airportsRepository.findAll();
    }

    @Override
    public void createAirport(AirportsDTO airportsDTO) {
        Airports airports = AirportsMapper.dtoToEntity(airportsDTO);
        airportsRepository.save(airports);
    }

    @Override
    public void deleteAirportById(Integer id) {
        airportsRepository.deleteById(id);
    }

}
