package ro.sda.travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.ContinentsDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Continents;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.ContinentsMapper;
import ro.sda.travel_agency.repository.ContinentsRepository;
import ro.sda.travel_agency.service.ContinentsService;

import java.util.List;
import java.util.Optional;
@Service
public class ContinentsServiceImpl implements ContinentsService {
    @Autowired
    ContinentsRepository continentsRepository;

    @Override
    public Optional<Continents> findContinentById(Integer id) {
        return continentsRepository.findById(id);
    }

    @Override
    public List<Continents> findAllContinents() {
        return continentsRepository.findAll();
    }

    @Override
    public void createContinent(ContinentsDTO continentsDTO) {
        Continents continents = ContinentsMapper.dtoToEntity(continentsDTO);
        continentsRepository.save(continents);
    }
    @Override
    public void updateContinent(Continents continent) {
        continentsRepository.save(continent);
    }
    @Override
    public void deleteContinentById(Integer id) {
        continentsRepository.deleteById(id);
    }
}