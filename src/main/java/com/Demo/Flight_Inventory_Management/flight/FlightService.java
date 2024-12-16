package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.Demo.Flight_Inventory_Management.airplane.AirplaneRepo;
import com.Demo.Flight_Inventory_Management.airport.Airport;
import com.Demo.Flight_Inventory_Management.airport.AirportRepo;
import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public FlightResponse findById(Long flightId) {

        return flightRepo.findById(flightId)
                .map(flightMapper::toFlightResponse)
                .orElseThrow(()-> new EntityNotFoundException("Flight with id " + flightId + " not found"));
    }

    public PageResponse<FlightResponse> findAllFlights(int page, int size,Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<Flight> flights = flightRepo.findAllAvailableFlight(pageable);
        List<FlightResponse> flightResponse = flights.stream()
                .map(flightMapper::toFlightResponse)
                .toList();
        return new PageResponse<>(
                flightResponse,
                flights.getNumber(),
                flights.getSize(),
                flights.getTotalElements(),
                flights.getTotalPages(),
                flights.isFirst(),
                flights.isLast()
        );
    }

    public void deleteFlightById(Long flightId ) {
        var flight = flightRepo.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with ID: " + flightId));
        flightRepo.delete(flight);
    }
}
