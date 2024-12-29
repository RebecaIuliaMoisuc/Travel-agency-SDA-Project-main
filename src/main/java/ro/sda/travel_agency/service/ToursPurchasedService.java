package ro.sda.travel_agency.service;

import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.TourPurchaseDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.ToursPurchased;

import java.util.List;

public interface ToursPurchasedService {
    ToursPurchased findToursPurchasedById(Integer id);

    List<ToursPurchased> findAllToursPurchased();

    void createToursPurchased(TourPurchaseDTO tourPurchaseDTO);

    void deleteTourPurchasedById(Integer id);
}