package com.Demo.Flight_Inventory_Management.bookingFlight;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking-flight")
@RequiredArgsConstructor
@Tag(name = "Booking-Flight")
public class BookingFlightController {

    private final BookingFlightService service ;
    @PostMapping
    public ResponseEntity<Long> saveBooking(
            @Valid @RequestBody BookingRequest request ,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.saveBooking(request,connectedUser));
    }


}
