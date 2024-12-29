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
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Cities;
import ro.sda.travel_agency.service.CitiesService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class CitiesController {
    @Autowired
    private CitiesService citiesService;

    @Operation(summary = "GET a city by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CitiesDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})

    @GetMapping(value = "/cities/{id}", produces = "application/json")
    public ResponseEntity<Cities> getCityById(@PathVariable("id") Integer id) {
        Optional<Cities> city = citiesService.findCityById(id);
        if (city.isPresent()) {
            return ResponseEntity.ok(city.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "GET all cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CitiesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })

    @GetMapping(value="/cities", produces = "application/json")
    public List<Cities> getCities() {
        return citiesService.findAllCities();
    }


    @Operation(summary = "Create a new City")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AirportsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_city")
    public CitiesDTO createNewDTOACity(@RequestBody CitiesDTO citiesDTO) {
        citiesService.createCity(citiesDTO);
        return citiesDTO;
    }

    @Operation(summary = "DELETE a city by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Airport deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/cities/{id}")
    public String deleteCityById(@PathVariable("id") Integer id) {
        citiesService.deleteCityById(id);
        return "City deleted successfully";
    }

}