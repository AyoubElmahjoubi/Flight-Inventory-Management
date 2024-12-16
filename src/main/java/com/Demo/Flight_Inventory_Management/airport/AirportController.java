package com.Demo.Flight_Inventory_Management.airport;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airport")
@RequiredArgsConstructor
@Tag(name = "Airport")
public class AirportController {

    private final AirportService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-airport")
    public ResponseEntity<Long> addAirport(
            @Valid @RequestBody AirportRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addAirport(request,connectedUser));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{airport-id}")
    public ResponseEntity<AirportResponse> findAirportById(
            @PathVariable("airport-id") Long airportId
    ){
        return ResponseEntity.ok(service.findById(airportId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-airports")
    public ResponseEntity<PageResponse<AirportResponse>>findAllAirports(
            @RequestParam(name = "page" ,defaultValue = "0", required = false)int page,
            @RequestParam(name = "size" ,defaultValue = "5", required = false)int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllAirport(page,size,connectedUser));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{airport-id}")
    public ResponseEntity<Void> deleteAirport(
            @PathVariable("airport-id") Long airportId
    ){
        service.deleteById(airportId);
        return ResponseEntity.noContent().build();
    }


}
