package ro.sda.travel_agency.dto;

import lombok.Data;

@Data
public class TourPurchaseDTO {

    private Integer tourPurchaseId;
    private ToursDTO tour;
    private Integer numberOfPersons;
    private Double totalPrice;
}
