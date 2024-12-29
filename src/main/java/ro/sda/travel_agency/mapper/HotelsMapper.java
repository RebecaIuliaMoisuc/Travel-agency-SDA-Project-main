package ro.sda.travel_agency.mapper;

import ro.sda.travel_agency.dto.HotelsDTO;
import ro.sda.travel_agency.entity.Hotels;

public class HotelsMapper {

    public static HotelsDTO entityToDTO(Hotels hotels) {
        if (hotels == null)
            return null;

        HotelsDTO hotelsDTO = new HotelsDTO();
        hotelsDTO.setHotelId(hotels.getHotel_id());
        hotelsDTO.setHotelName(hotelsDTO.getHotelName());
        hotelsDTO.setNumberOfStars(hotels.getNumber_of_stars());
        hotelsDTO.setDescription(hotels.getDescription());
        hotelsDTO.setCity(CitiesMapper.entityToDTO(hotels.getCity()));

        return hotelsDTO;
    }

    public static Hotels dtoToEntity(HotelsDTO hotelsDTO) {
        if (hotelsDTO == null)
            return null;

        Hotels hotels=new Hotels();
        hotels.setHotel_id(hotelsDTO.getHotelId());
        hotels.setHotel_name(hotelsDTO.getHotelName());
        hotels.setNumber_of_stars(hotelsDTO.getNumberOfStars());
        hotels.setDescription(hotelsDTO.getDescription());
        hotels.setCity(CitiesMapper.dtoToEntity(hotelsDTO.getCity()));

        return hotels;
    }
}
