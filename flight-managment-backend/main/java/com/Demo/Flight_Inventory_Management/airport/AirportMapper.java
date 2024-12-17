package com.Demo.Flight_Inventory_Management.airport;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AirportMapper {


    public Airport toAirport(AirportRequest request) {
        return Airport.builder()
                .airport_id(request.id())
                .airport_name(request.airportName())
                .iata_code(request.iaatCode())
                .city(request.city())
                .createdDate(LocalDateTime.now())
                .country(request.country())
                .build();
    }

    public AirportResponse toAirpotResponse(Airport airport) {

        return AirportResponse.builder()
                .airport_id(airport.getAirport_id())
                .airport_name(airport.getAirport_name())
                .iata_code(airport.getIata_code())
                .city(airport.getCity())
                .country(airport.getCountry())
                .build();
    }
}
