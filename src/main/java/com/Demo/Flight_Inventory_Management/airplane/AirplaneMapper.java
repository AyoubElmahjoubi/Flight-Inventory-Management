package com.Demo.Flight_Inventory_Management.airplane;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AirplaneMapper {

    public Airplane toAirplane(@Valid AirplaneRequest request) {
        return Airplane.builder()
                .airplane_id(request.id())
                .model(request.model())
                .capacity(request.capacity())
                .dateFabrication(request.dateFabrication())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public AirplaneResponse toAirplaneResponse(Airplane airplane) {
        return AirplaneResponse.builder()
                .airplane_id(airplane.getAirplane_id())
                .model(airplane.getModel())
                .capacity(airplane.getCapacity())
                .dateFabrication(airplane.getDateFabrication())
                .build();
    }
}
