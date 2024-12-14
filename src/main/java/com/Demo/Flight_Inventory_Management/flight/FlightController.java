package com.Demo.Flight_Inventory_Management.flight;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
@Tag(name = "Flight")
public class FlightController {

    private final FlightService service;

    @PostMapping("/add-Flight")
    public ResponseEntity<Long> addFlight(
            @Valid @RequestBody FlightRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addFlight(request ,connectedUser));
    }

}
