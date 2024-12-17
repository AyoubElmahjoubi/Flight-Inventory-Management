package com.Demo.Flight_Inventory_Management.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AirportMapperTest {

    private AirportMapper airportMapper;

    @BeforeEach
    void setUp() {
        airportMapper = new AirportMapper();
    }
    @Test
    public void mapAirportMapperToAirport() {
        AirportRequest request = new AirportRequest(
                1L,
                "mohammed 6",
                "MAA",
                "casablanca",
                "maroc"
        );

        Airport airport = airportMapper.toAirport(request);
        assertEquals(request.id(),airport.getAirport_id());
        assertEquals(request.airportName(),airport.getAirport_name());
        assertEquals(request.iaatCode(),airport.getIata_code());
        assertEquals(request.city(),airport.getCity());
        assertEquals(request.country(),airport.getCountry());

    }




}