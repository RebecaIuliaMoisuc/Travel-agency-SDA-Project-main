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
import ro.sda.travel_agency.entity.Continents;
import ro.sda.travel_agency.entity.Hotels;
import ro.sda.travel_agency.service.ContinentsService;
import ro.sda.travel_agency.service.HotelsService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class HotelsController {
    @Autowired
    public HotelsService hotelsService;

    @Operation(summary = "GET a hotel by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContinentsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})

    @GetMapping(value = "/hotels/{id}", produces = "application/json")
    public ResponseEntity<Hotels> getHotelById(@PathVariable("id")Integer id){
        Optional<Hotels> hotel = hotelsService.findHotelById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "GET all hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContinentsDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content) })

    @GetMapping(value="/hotels", produces = "application/json")
    public List<Hotels> getHotels() {
        return hotelsService.findAllHotels();
    }

    @Operation(summary = "Create a new Hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connection up, operation successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HotelsDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_hotel")
    public HotelsDTO createNewDTOHotel(@RequestBody HotelsDTO hotelsDTO) {
        hotelsService.createHotel(hotelsDTO);
        return hotelsDTO;
    }

    @Operation(summary = "DELETE a hotel by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content) })
    @DeleteMapping("/hotels/{id}")
    public String deleteHoteltById(@PathVariable("id") Integer id) {
        hotelsService.deleteHotelById(id);
        return "Hotel deleted successfully";
    }



}