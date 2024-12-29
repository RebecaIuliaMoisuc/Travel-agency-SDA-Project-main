package ro.sda.travel_agency.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportsDTO {

    private Integer airportId;
    private String airportName;
    private CitiesDTO city;

}
