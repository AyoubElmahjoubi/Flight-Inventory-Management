package com.Demo.Flight_Inventory_Management.flight;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Query("""
        SELECT flight FROM Flight flight
        WHERE flight.status = 'AVAILABLE' 
        """
    )
    Page<Flight> findAllAvailableFlight(Pageable pageable);
}



