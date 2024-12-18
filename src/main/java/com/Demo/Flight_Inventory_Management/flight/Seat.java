package com.Demo.Flight_Inventory_Management.flight;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    private boolean isAvailable;
    private boolean isReserved;



}
