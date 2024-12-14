package com.Demo.Flight_Inventory_Management.flight;


import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.Demo.Flight_Inventory_Management.airport.Airport;
import org.springframework.stereotype.Service;

@Service
public class FlightMapper {

    public Flight toFlight(FlightRequest request , Airport departureFrom ,Airport arrivalTo, Airplane airplane) {
        return Flight.builder()
                .flight_id(request.id())
                .flightNumber(request.flightNumber())
                .flight_departure(request.departureTime())
                .flight_arrival(request.arrivalTime())
                .departureFrom(departureFrom)
                .arrivalTo(arrivalTo)
                .airplane(airplane)
                .basePrice(request.basePrice())
                .status(FlightStatus.AVAILABLE)
                .build();
    }
}
