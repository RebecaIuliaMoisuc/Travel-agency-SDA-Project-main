package ro.sda.travel_agency.service.impl;

import org.springframework.stereotype.Service;
import ro.sda.travel_agency.dto.TourPurchaseDTO;
import ro.sda.travel_agency.entity.ToursPurchased;
import ro.sda.travel_agency.mapper.ToursPurchasedMapper;
import ro.sda.travel_agency.repository.ToursPurchasedRepository;
import ro.sda.travel_agency.service.ToursPurchasedService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class ToursPurchasedServiceImpl implements ToursPurchasedService {
     @Autowired
    private ToursPurchasedRepository toursPurchasedRepository;


    @Override
    public ToursPurchased findToursPurchasedById(Integer id) {
        return toursPurchasedRepository.findById(id).get();
    }

    @Override
    public List<ToursPurchased> findAllToursPurchased() {
        return toursPurchasedRepository.findAll();
    }

    @Override
    public void createToursPurchased(TourPurchaseDTO tourPurchaseDTO) {
    ToursPurchased toursPurchased = ToursPurchasedMapper.dtoToEntity(tourPurchaseDTO);
    toursPurchasedRepository.save(toursPurchased);
    }

    @Override
    public void deleteTourPurchasedById(Integer id) {
        toursPurchasedRepository.deleteById(id);
    }
}