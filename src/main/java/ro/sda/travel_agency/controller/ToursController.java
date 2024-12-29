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
import ro.sda.travel_agency.dto.CitiesDTO;
import ro.sda.travel_agency.dto.ContinentsDTO;
import ro.sda.travel_agency.dto.ToursDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Tours;
import ro.sda.travel_agency.mapper.AirportsMapper;
import ro.sda.travel_agency.mapper.ToursMapper;
import ro.sda.travel_agency.service.HotelsService;
import ro.sda.travel_agency.service.ToursService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class ToursController {
    @Autowired
    public ToursService toursService;

@Operation(summary = "GET a tour by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToursDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
@GetMapping(value="/tours/{id}", produces = "application/json")
public ToursDTO getATourById(@PathVariable("id") Integer id){
    return ToursMapper.entityToDTO(toursService.findToursById(id));
}

    @Operation(summary = "GET all tours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToursDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })

    @GetMapping(value="/tours", produces = "application/json")
    public List<Tours> getTours() {
        return toursService.findAllTours();
    }

    @Operation(summary = "Create a new Tour")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToursDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_tour")
    public ToursDTO createNewDTOTour(@RequestBody ToursDTO tourDTO) {
        toursService.createTour(tourDTO);
        return tourDTO;
    }

    @Operation(summary = "DELETE a tour by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tour deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/tours/{id}")
    public String deleteTourById(@PathVariable("id") Integer id) {
        toursService.deleteTourById(id);
        return "Tour deleted successfully";
    }
}