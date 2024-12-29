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
import ro.sda.travel_agency.dto.CountriesDTO;
import ro.sda.travel_agency.entity.Airports;
import ro.sda.travel_agency.entity.Countries;
import ro.sda.travel_agency.service.CountriesService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api")
public class CountriesController {
    @Autowired
    private CountriesService countriesService;

    @Operation(summary = "GET an country by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CountriesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })

    @GetMapping(value="/countries/{id}", produces = "application/json")
    public ResponseEntity<Countries> getCountryById(@PathVariable("id") Integer id) {
        Optional<Countries> country = countriesService.findCountryById(id);
        if (country.isPresent()) {
            return ResponseEntity.ok(country.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "GET all countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CountriesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })
    @GetMapping(value="/countries", produces = "application/json")
    public List<Countries> getCountries() {
        return countriesService.findAllCountries();
    }

    @Operation(summary = "Create a new Country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AirportsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_country")
    public CountriesDTO createNewDTOCountry(@RequestBody CountriesDTO countriesDTO) {
        countriesService.createCountry(countriesDTO);
        return countriesDTO;
    }

    @Operation(summary = "DELETE a country by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Airport deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/countries/{id}")
    public String deleteCountryById(@PathVariable("id") Integer id) {
        countriesService.deleteCountryById(id);
        return "Country deleted successfully";
    }
}