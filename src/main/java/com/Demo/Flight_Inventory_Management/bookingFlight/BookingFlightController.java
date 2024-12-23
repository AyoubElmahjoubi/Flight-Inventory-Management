package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import com.Demo.Flight_Inventory_Management.flight.FlightResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("all-bookings")
    public ResponseEntity<PageResponse<BookingResponse>>findAllBookings(
            @RequestParam(name = "page" ,defaultValue = "0", required = false)int page,
            @RequestParam(name = "size" ,defaultValue = "5", required = false)int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllBooking(page,size,connectedUser));
    }

}
