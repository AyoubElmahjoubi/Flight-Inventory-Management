package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.Demo.Flight_Inventory_Management.flight.Flight;
import com.Demo.Flight_Inventory_Management.flight.FlightRepo;
import com.Demo.Flight_Inventory_Management.user.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingFlightService {

    private final BookingMapper bookingMapper;
    private final BookingRepo bookingRepo;
    private final FlightRepo flightRepo;

    public Long saveBooking( BookingRequest request, Authentication connectedUser) {

        Flight flight = flightRepo.findById(request.flightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));

        User user = (User) connectedUser.getPrincipal();
        Booking booking = bookingMapper.toBooking(request,flight);
        booking.setBookedBy(user);
        booking.totalPrice();
        return bookingRepo.save(booking).getBookingId();
    }
}
