package ro.sda.travel_agency.dto;

import lombok.Data;

@Data
public class CountriesDTO {

    private Integer countryId;
    private String countryName;
    private ContinentsDTO continent;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ContinentsDTO getContinent() {
        return continent;
    }

    public void setContinent(ContinentsDTO continent) {
        this.continent = continent;
    }
}
