package ro.sda.travel_agency.dto;

import lombok.Data;

@Data
public class ContinentsDTO {

    private String continent_name;

    // Getters and setters
    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }
}
