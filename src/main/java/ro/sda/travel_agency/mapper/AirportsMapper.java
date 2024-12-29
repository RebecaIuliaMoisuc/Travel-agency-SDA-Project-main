package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.AirportsDTO;
import ro.sda.travel_agency.entity.Airports;

public class AirportsMapper {

    public static AirportsDTO entityToDTO(Airports airports) {
        if (airports == null)
            return null;
        AirportsDTO airportsDTO = new AirportsDTO();
        airportsDTO.setAirportId(airports.getAirport_id());
        airportsDTO.setAirportName(airports.getAirport_name());
        airportsDTO.setCity(CitiesMapper.entityToDTO(airports.getCity()));
        return airportsDTO;
    }

    public static Airports dtoToEntity(AirportsDTO airportsDTO) {
        if (airportsDTO == null)
            return null;
        Airports airports = new Airports();
        airports.setAirport_id(airportsDTO.getAirportId());
        airports.setAirport_name(airportsDTO.getAirportName());
        airports.setCity(CitiesMapper.dtoToEntity(airportsDTO.getCity()));
        return airports;

    }

}
