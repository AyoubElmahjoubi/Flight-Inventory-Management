package com.Demo.Flight_Inventory_Management.airport;

import com.Demo.Flight_Inventory_Management.flight.Flight;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airport_id;
    private String airport_name;
    private String iata_code;
    private String city;
    private String country;
    @OneToOne(mappedBy = "departureFrom")
    private Flight flight;
    @OneToOne(mappedBy = "arrivalTo")
    private Flight flight2 ;
}
