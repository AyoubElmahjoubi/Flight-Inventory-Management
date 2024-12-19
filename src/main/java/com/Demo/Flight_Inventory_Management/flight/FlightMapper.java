package com.Demo.Flight_Inventory_Management.flight;


import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.Demo.Flight_Inventory_Management.airport.Airport;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

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
                .bagageCapacity(request.bagageCapacity())
                .CabinCapacity(request.CabinCapacity())
                .flightEscale(request.flightEscale())
                .flightClass(request.flightClass())
                .basePrice(request.basePrice())
                .status(FlightStatus.AVAILABLE)
                .createdDate(LocalDateTime.now())
                .build();
    }

    public FlightResponse toFlightResponse(Flight flight) {
        return FlightResponse.builder()
                .flight_id(flight.getFlight_id())
                .flightNumber(flight.getFlightNumber())
                .flight_departure(flight.getFlight_departure())
                .flight_arrival(flight.getFlight_arrival())
                .basePrice(flight.getBasePrice())
                .status(String.valueOf(flight.getStatus()))
                .bagageCapacity(flight.getBagageCapacity())
                .CabinCapacity(flight.getCabinCapacity())
                .flightEscale(flight.getFlightEscale())
                .flightClass(flight.getFlightClass())
                .departureFrom(flight.getDepartureFrom().getAirport_name())
                .arrivalTo(flight.getArrivalTo().getAirport_name())
                .build();
    }
}
