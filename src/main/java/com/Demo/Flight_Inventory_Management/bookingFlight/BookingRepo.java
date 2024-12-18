package com.Demo.Flight_Inventory_Management.bookingFlight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
