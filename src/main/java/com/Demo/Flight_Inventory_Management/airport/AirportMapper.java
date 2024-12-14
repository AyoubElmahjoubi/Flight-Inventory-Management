package com.Demo.Flight_Inventory_Management.airport;

import org.springframework.stereotype.Service;

@Service
public class AirportMapper {


    public Airport toAirport(AirportRequest request) {
        return Airport.builder()
                .airport_id(request.id())
                .airport_name(request.airportName())
                .iata_code(request.iaatCode())
                .city(request.city())
                .country(request.country())
                .build();
    }
}
