package ro.sda.travel_agency.dto;

import lombok.Data;

import java.sql.Date;
import java.time.Instant;

@Data
public class ToursDTO {

    private Integer tourId;
    private CitiesDTO fromCity;
    private CitiesDTO toCity;
    private HotelsDTO hotel;
    private AirportsDTO airport;
    private Instant departureDate;
    private Instant returnDate;
    private Integer numberOfDays;
    private String type;
    private Double adultPrice;
    private Double childPrice;
    private boolean promoted;
    private String adultSeats;
    private String childSeats;

}
