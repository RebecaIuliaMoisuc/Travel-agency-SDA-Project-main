package ro.sda.travel_agency.dto;

import lombok.Data;

@Data
public class HotelsDTO {

    private Integer hotelId;
    private String hotelName;
    private Integer numberOfStars;
    private String description;
    private CitiesDTO city;

}
