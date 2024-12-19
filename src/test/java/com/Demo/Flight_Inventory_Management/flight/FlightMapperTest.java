package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.airplane.AirplaneMapper;
import com.Demo.Flight_Inventory_Management.airplane.AirplaneRequest;
import com.Demo.Flight_Inventory_Management.airport.AirportMapper;
import com.Demo.Flight_Inventory_Management.airport.AirportRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlightMapperTest {

    private FlightMapper flightMapper ;
    private AirplaneMapper airplaneMapper ;
    private AirportMapper airportMapper ;
    private AirportRequest departureFrom;
    private AirportRequest arrivalTo;
    private AirplaneRequest airplane;



    @BeforeEach
    void setUp() {
        flightMapper = new FlightMapper();
        airplaneMapper = new AirplaneMapper();
        airportMapper = new AirportMapper();

        departureFrom = new AirportRequest(1L, "med 6","JFK", "Nador","maroc");
        arrivalTo = new AirportRequest(2L, "med 5", "LOS","beni mella","maroc");
        airplane = new AirplaneRequest(1L, "Boeing 737", 180,"2020-3-21");
    }

//    @Test
//    public void shouldMapFlightMapperToFlight() {
//
//        FlightRequest request = new FlightRequest(
//                1L,
//                "FL123",
//                LocalDate.of(2024, 12, 25),
//                LocalDate.of(2024, 12, 26),
//                200.0,
//                1L,
//                2L,
//                23,
//                1L
//        );
//
//        var depart = airportMapper.toAirport(departureFrom);
//        var arrival = airportMapper.toAirport(arrivalTo);
//        var airpalneobj = airplaneMapper.toAirplane(airplane);
//
//
//        Flight flight = flightMapper.toFlight(request, depart, arrival, airpalneobj);
//
//
//        assertNotNull(flight);
//        assertEquals(1L, flight.getFlight_id());
//        assertEquals("FL123", flight.getFlightNumber());
//        assertEquals(LocalDate.of(2024, 12, 25), flight.getFlight_departure());
//        assertEquals(LocalDate.of(2024, 12, 26), flight.getFlight_arrival());
//        assertEquals(depart.getAirport_name(), flight.getDepartureFrom().getAirport_name());
//        assertEquals(depart.getIata_code(), flight.getDepartureFrom().getIata_code());
//        assertEquals(depart.getCity(), flight.getDepartureFrom().getCity());
//        assertEquals(depart.getCountry(), flight.getDepartureFrom().getCountry());
//        assertEquals(arrival.getAirport_name(), flight.getArrivalTo().getAirport_name());
//        assertEquals(arrival.getIata_code(), flight.getArrivalTo().getIata_code());
//        assertEquals(arrival.getCity(), flight.getArrivalTo().getCity());
//        assertEquals(arrival.getCountry(), flight.getArrivalTo().getCountry());
//        assertEquals(airpalneobj.getAirplane_id(), flight.getAirplane().getAirplane_id());
//        assertEquals(200.0, flight.getBasePrice());
//        assertEquals(FlightStatus.AVAILABLE, flight.getStatus());
//        assertNotNull(flight.getCreatedDate());
//    }

}