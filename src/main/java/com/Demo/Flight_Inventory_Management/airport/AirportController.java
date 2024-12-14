package com.Demo.Flight_Inventory_Management.airport;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("airport")
@RequiredArgsConstructor
@Tag(name = "Airport")
public class AirportController {

    @Autowired
    private AirportService service;

    @PostMapping("/add-airport")
    public ResponseEntity<Long> addAirport(
            @Valid @RequestBody AirportRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addAirport(request,connectedUser));
    }

}
