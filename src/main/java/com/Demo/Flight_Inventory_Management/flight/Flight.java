package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.Demo.Flight_Inventory_Management.airport.Airport;
import com.Demo.Flight_Inventory_Management.bookingFlight.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;
    private String flightNumber;
    @Enumerated(EnumType.STRING)
    private FlightStatus status ;
    @Temporal(TemporalType.DATE)
    private LocalDate flight_departure;
    private double basePrice;
    @Temporal(TemporalType.DATE)
    private LocalDate flight_arrival;
    @OneToOne()
    private Airport departureFrom;
    @OneToOne()
    private Airport arrivalTo;
    @OneToMany( mappedBy = "flight", fetch = FetchType.LAZY)
    private Collection<Seat> flight_available_seats;

    @OneToOne
    @JoinColumn(name = "airplane")
    private Airplane airplane;
    @OneToMany (mappedBy = "flight")
    private Collection<FlightMember> flightMember;
    @OneToOne(mappedBy = "flight")
    private Booking booking;

}
