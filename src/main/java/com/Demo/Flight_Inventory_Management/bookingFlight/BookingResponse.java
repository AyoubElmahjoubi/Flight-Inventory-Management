package com.Demo.Flight_Inventory_Management.bookingFlight;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingResponse {

    private Long bookingId;
    private String passengerName;
    private String passengerEmail;
}
