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
import ro.sda.travel_agency.entity.Cities;
import ro.sda.travel_agency.entity.Continents;
import ro.sda.travel_agency.mapper.ContinentsMapper;
import ro.sda.travel_agency.service.ContinentsService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class ContinentsController {
    @Autowired
    public ContinentsService continentsService;

    @Operation(summary = "GET a continent by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContinentsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})


    @GetMapping(value = "/continents/{id}", produces = "application/json")
    public ResponseEntity<Continents> getContinentById(@PathVariable("id")Integer id){
        Optional<Continents> continent = continentsService.findContinentById(id);
        if (continent.isPresent()) {
            return ResponseEntity.ok(continent.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "GET all continents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContinentsDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })

    @GetMapping(value="/continents", produces = "application/json")
    public List<Continents> getContinents() {
        return continentsService.findAllContinents();
    }

    @Operation(summary = "Create a new Continent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AirportsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new_continent")
    public ContinentsDTO createNewDTOContinent(@RequestBody ContinentsDTO continentsDTO) {
        continentsService.createContinent(continentsDTO);
        return continentsDTO;
    }


    @Operation(summary = "DELETE a continent by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Airport deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/continents/{id}")
    public String deleteContinentById(@PathVariable("id") Integer id) {
        continentsService.deleteContinentById(id);
        return "Continent deleted successfully";
    }

    @Operation(summary = "Update a Continent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Continent updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContinentsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PutMapping("/continents/{id}")
    public ResponseEntity<ContinentsDTO> updateContinent(
            @PathVariable("id") Integer id,
            @RequestBody ContinentsDTO continentsDTO) {
        Optional<Continents> existingContinent = continentsService.findContinentById(id);

        if (existingContinent.isPresent()) {
            Continents updatedContinent = existingContinent.get();
            updatedContinent.setContinent_name(continentsDTO.getContinent_name());
            continentsService.updateContinent(updatedContinent);
            return ResponseEntity.ok(ContinentsMapper.entityToDTO(updatedContinent));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}