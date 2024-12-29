package ro.sda.travel_agency.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackagesDTO {
    private String packageName;
    private String description;
    private Double price;
   private Integer availablePackages;
}