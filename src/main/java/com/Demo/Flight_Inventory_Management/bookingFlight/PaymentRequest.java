package com.Demo.Flight_Inventory_Management.bookingFlight;

public record PaymentRequest(

        Long bookingId,

        String paymentMethod ,

        double amount



) {
}
