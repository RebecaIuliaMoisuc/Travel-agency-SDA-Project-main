package ro.sda.travel_agency.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.dto.ContinentsDTO;
import ro.sda.travel_agency.dto.HotelsDTO;
import ro.sda.travel_agency.dto.TourPurchaseDTO;
import ro.sda.travel_agency.entity.Hotels;
import ro.sda.travel_agency.entity.ToursPurchased;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.ToursPurchasedMapper;
import ro.sda.travel_agency.service.ToursPurchasedService;
import ro.sda.travel_agency.service.ToursService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class ToursPurchasedController {
    @Autowired
    private ToursPurchasedService toursPurchasedService;

    @Operation(summary = "GET a purchased tour by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TourPurchaseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})

    @GetMapping(value = "/toursPurchased/{id}", produces = "application/json")
    public TourPurchaseDTO getTourPurchasedById(@PathVariable("id") Integer id){
        return ToursPurchasedMapper.entityToDTO(toursPurchasedService.findToursPurchasedById(id));
    }

    @Operation(summary = "GET all purchased tours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TourPurchaseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })

    @GetMapping(value="/toursPurchased", produces = "application/json")
    public List<ToursPurchased> getToursPurchased() {
        return toursPurchasedService.findAllToursPurchased();
    }

    @Operation(summary = "Create a new purchased tour")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TourPurchaseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_tourPurchased")
    public TourPurchaseDTO createNewDTOTourPurchased(@RequestBody TourPurchaseDTO tourPurchasedDTO) {
        toursPurchasedService.createToursPurchased(tourPurchasedDTO);
        return tourPurchasedDTO;
    }

    @Operation(summary = "DELETE a purchased tour by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/tourPurchased/{id}")
    public String deleteTourPurchasedById(@PathVariable("id") Integer id) {
        toursPurchasedService.deleteTourPurchasedById(id);
        return "purchased tour deleted successfully";
    }

}