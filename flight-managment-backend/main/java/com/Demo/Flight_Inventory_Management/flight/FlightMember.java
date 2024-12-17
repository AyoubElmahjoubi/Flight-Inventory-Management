package com.Demo.Flight_Inventory_Management.flight;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightMemberId;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    private String roleOnFlight;
}
