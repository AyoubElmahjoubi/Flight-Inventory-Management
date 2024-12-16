package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
@Tag(name = "Flight")
public class FlightController {

    private final FlightService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-Flight")
    public ResponseEntity<Long> addFlight(
            @Valid @RequestBody FlightRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addFlight(request ,connectedUser));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{flight-id}")
    public ResponseEntity<FlightResponse>findFlightById(
            @PathVariable("flight-id") Long flightId
    ){
        return ResponseEntity.ok(service.findById(flightId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("all-flights")
    public ResponseEntity<PageResponse<FlightResponse>>findAllFlights(
            @RequestParam(name = "page" ,defaultValue = "0", required = false)int page,
            @RequestParam(name = "size" ,defaultValue = "5", required = false)int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllFlights(page,size,connectedUser));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{flight-id}")
    public ResponseEntity<Void> deleteFlightById(
            @PathVariable("flight-id") Long flightId
    ) {
        service.deleteFlightById(flightId);
        return ResponseEntity.noContent().build();
    }
}
