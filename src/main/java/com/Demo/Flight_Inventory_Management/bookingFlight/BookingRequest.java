package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record BookingRequest(

        Long id,
        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String passengerFirstName,

        @NotNull(message = "101")
        @NotEmpty(message = "101")
        String passengerLastName,

        String cardId,

        String passportId,

        @NotNull(message = "102")
        @NotEmpty(message = "102")
        String passengerEmail,

        String phoneNumber,

        @NotNull
        @NotEmpty
        Long flightId,

        @NotNull(message = "108")
        @NotEmpty(message = "108")
        int numberOfSeats





) {
}
