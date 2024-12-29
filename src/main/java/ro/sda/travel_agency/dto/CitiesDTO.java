package ro.sda.travel_agency.dto;

import lombok.Data;

@Data
public class CitiesDTO {

        private Integer cityId;
        private String cityName;
        private CountriesDTO country;
}
