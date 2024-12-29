package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.ToursDTO;
import ro.sda.travel_agency.entity.Tours;

import java.sql.Date;

public class ToursMapper {

    public static ToursDTO entityToDTO(Tours tours) {
        if (tours == null)
            return null;
        ToursDTO toursDTO = new ToursDTO();
        toursDTO.setTourId(tours.getTour_id());
        toursDTO.setType(tours.getType());
        toursDTO.setFromCity(CitiesMapper.entityToDTO(tours.getFrom_city()));
        toursDTO.setToCity(CitiesMapper.entityToDTO(tours.getTo_city()));
        toursDTO.setHotel(HotelsMapper.entityToDTO(tours.getTo_hotel()));
        toursDTO.setAirport(AirportsMapper.entityToDTO(tours.getTo_airport()));
        toursDTO.setDepartureDate(tours.getDeparture_date() != null ? Date.from(tours.getDeparture_date()).toInstant() : null);
        toursDTO.setReturnDate(tours.getReturn_date() != null ? Date.from(tours.getReturn_date()).toInstant() : null);
        toursDTO.setNumberOfDays(tours.getNumber_of_days());
        toursDTO.setAdultPrice(tours.getAdult_price());
        toursDTO.setChildPrice(tours.getChild_price());
        toursDTO.setPromoted(tours.isPromoted());
        toursDTO.setAdultSeats(tours.getAdult_seats());
        toursDTO.setChildSeats(tours.getChild_seats());
        return toursDTO;
    }

    public static Tours dtoToEntity(ToursDTO toursDTO) {
        if (toursDTO == null)
            return null;
        Tours tours = new Tours();
        tours.setTour_id(toursDTO.getTourId());
        tours.setType(toursDTO.getType());
        tours.setFrom_city(CitiesMapper.dtoToEntity(toursDTO.getFromCity()));
        tours.setTo_city(CitiesMapper.dtoToEntity(toursDTO.getToCity()));
        tours.setTo_hotel(HotelsMapper.dtoToEntity(toursDTO.getHotel()));
        tours.setTo_airport(AirportsMapper.dtoToEntity(toursDTO.getAirport()));
        tours.setDeparture_date(toursDTO.getDepartureDate());
        tours.setReturn_date(toursDTO.getReturnDate());
        tours.setNumber_of_days(toursDTO.getNumberOfDays());
        tours.setAdult_price(toursDTO.getAdultPrice());
        tours.setChild_price(toursDTO.getChildPrice());
        tours.setPromoted(toursDTO.isPromoted());
        tours.setAdult_seats(toursDTO.getAdultSeats());
        tours.setChild_seats(toursDTO.getChildSeats());
        return tours;

    }
}
