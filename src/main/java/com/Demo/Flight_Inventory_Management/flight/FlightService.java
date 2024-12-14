package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.Demo.Flight_Inventory_Management.airplane.AirplaneRepo;
import com.Demo.Flight_Inventory_Management.airport.Airport;
import com.Demo.Flight_Inventory_Management.airport.AirportRepo;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepo flightRepo;
    private final FlightMapper flightMapper;
    private final AirportRepo airportRepo;
    private final AirplaneRepo airplaneRepo;


    public Long addFlight(FlightRequest request, Authentication connectedUser) {

        Airport departureAirport = airportRepo.findById(request.departureFromId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid departure airport ID"));
        Airport arrivalAirport = airportRepo.findById(request.arrivalToId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid arrival airport ID"));

        Airplane airplane = airplaneRepo.findById(request.airplaneId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid airplane ID"));

        User user = (User) connectedUser.getPrincipal();
        Flight flight = flightMapper.toFlight(request, departureAirport, arrivalAirport, airplane);
        return flightRepo.save(flight).getFlight_id();
    }
}
