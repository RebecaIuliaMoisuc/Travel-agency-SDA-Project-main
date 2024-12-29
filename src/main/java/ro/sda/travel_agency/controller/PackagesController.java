package ro.sda.travel_agency.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sda.travel_agency.dto.PackagesDTO;
import ro.sda.travel_agency.entity.Packages;
import ro.sda.travel_agency.mapper.PackagesMapper;
import ro.sda.travel_agency.service.PackagesService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PackagesController {

    @Autowired
    private PackagesService packagesService;

    @Operation(summary = "GET all packages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entities",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackagesDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entities not found",
                    content = @Content)})
    @GetMapping(value = "/packages", produces = "application/json")
    public List<Packages> getAllPackages() {
        return packagesService.findAllPackages();
    }

    @Operation(summary = "GET a package by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the requested entity",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackagesDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @GetMapping(value = "/packages/{id}", produces = "application/json")
    public PackagesDTO getPackageById(@PathVariable("id") Integer id) {
        return PackagesMapper.entityToDTO(packagesService.findPackageById(id));
    }

    @Operation(summary = "Create a new package")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackagesDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @PostMapping("/new_package")
    public PackagesDTO createNewPackage(@RequestBody PackagesDTO packagesDTO) {
        packagesService.createPackage(packagesDTO);
        return packagesDTO;
    }

    @Operation(summary = "DELETE a package by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @DeleteMapping("/packages/{id}")
    public String deletePackageById(@PathVariable("id") Integer id) {
        packagesService.deletePackageById(id);
        return "Package deleted successfully";
    }

    @Operation(summary = "Reserve a package")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package reserved successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackagesDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Package not found",
                    content = @Content)})
    @PostMapping("/packages/reserve")
    public PackagesDTO reservePackage(@RequestBody Integer packageId) {
        return PackagesMapper.entityToDTO(packagesService.reservePackage(packageId));
    }

}
