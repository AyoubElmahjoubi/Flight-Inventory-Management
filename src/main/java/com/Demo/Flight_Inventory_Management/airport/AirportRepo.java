package com.Demo.Flight_Inventory_Management.airport;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepo extends JpaRepository<Airport, Long> {

    Optional<Airport> findById(Long airport_Id);
}
