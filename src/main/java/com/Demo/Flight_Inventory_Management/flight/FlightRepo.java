package com.Demo.Flight_Inventory_Management.flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Long> {

}
