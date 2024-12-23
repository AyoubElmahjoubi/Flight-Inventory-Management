package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.Demo.Flight_Inventory_Management.flight.Flight;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingMapper {


    public Booking toBooking(BookingRequest request , Flight flight) {
        return Booking.builder()
                .bookingId(request.id())
                .passengerFirstName(request.passengerFirstName())
                .passengerLastName(request.passengerLastName())
                .passengerEmail(request.passengerEmail())
                .numberOfSeats(request.numberOfSeats())
                .passengerIdentityId(request.cardId())
                .passengerPhone(request.phoneNumber())
                .passengerPassportId(request.passportId())
                .flight(flight)
                .bookingDate(new Date())
                .status(BookingStatus.EN_ATTENTE)
                .build();
    }

    public BookingResponse tobookingResponse(Booking booking) {
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .passengerName(booking.getPassengerFirstName())
                .passengerEmail(booking.getPassengerEmail())
                .build();
    }
}
