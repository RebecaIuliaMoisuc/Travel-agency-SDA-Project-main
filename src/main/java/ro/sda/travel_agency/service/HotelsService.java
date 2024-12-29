package ro.sda.travel_agency.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel_agency.dto.ContinentsDTO;
import ro.sda.travel_agency.entity.Countries;
import ro.sda.travel_agency.entity.Hotels;
import ro.sda.travel_agency.dto.HotelsDTO;

import java.util.List;
import java.util.Optional;

public interface HotelsService {
    Optional<Hotels> findHotelById(Integer id);

    List<Hotels> findAllHotels();

    void createHotel(HotelsDTO hotelsDTO);

    void deleteHotelById(Integer id);
}
