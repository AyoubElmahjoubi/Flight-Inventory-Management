package com.Demo.Flight_Inventory_Management.airplane;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class AirplaneMapper {

    public Airplane toAirplane(@Valid AirplaneRequest request) {
        return Airplane.builder()
                .airplane_id(request.id())
                .model(request.model())
                .capacity(request.capacity())
                .dateFabrication(request.dateFabrication())
                .build();
    }
}
