package com.Demo.Flight_Inventory_Management.bookingFlight;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public ResponseEntity<Long> saveBooking(
            @Valid @RequestBody BookingRequest request ,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.saveBooking(request,connectedUser));
    }

    @PostMapping("/confirm-payment")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<String> confirmPayment(
            @Valid @RequestBody PaymentRequest paymentRequest,
            Authentication connectedUser
    ) {
        boolean paymentSuccess = service.processPayment(paymentRequest, connectedUser);
        if (paymentSuccess) {
            return ResponseEntity.ok("Payment confirmed and booking updated!");
        } else {
            return ResponseEntity.badRequest().body("Payment failed!");
        }
    }

}
