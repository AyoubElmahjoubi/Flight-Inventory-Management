package com.Demo.Flight_Inventory_Management.flight;


import com.Demo.Flight_Inventory_Management.airport.Airport;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

    private Long flight_id;
    private String flightNumber;
    private String status ;
    private LocalDateTime flight_departure;
    private LocalDateTime flight_arrival;
    private double basePrice;
    private String departureFrom;
    private String arrivalTo;
    private String flightClass;
    private String flightEscale;
    private String program;
    private double bagageCapacity;
    private double CabinCapacity;

}
