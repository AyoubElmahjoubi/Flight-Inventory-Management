package com.Demo.Flight_Inventory_Management.airplane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneMapperTest {

    private AirplaneMapper airplaneMapper;

    @BeforeEach
    void setUp() {
        airplaneMapper = new AirplaneMapper();
    }

    @Test
    public void shouldMapAirplaneRequestToAirplane(){
        AirplaneRequest request = new AirplaneRequest(
                1L,
                "Boeing 747",
                400,
                "2020-01-01");

        Airplane airplane = airplaneMapper.toAirplane(request);
        assertEquals(request.id(),airplane.getAirplane_id());
        assertEquals(request.model(), airplane.getModel());
        assertEquals(request.capacity(), airplane.getCapacity());
        assertEquals(request.dateFabrication(), airplane.getDateFabrication());
    }

//    @Test
//    void testToAirplaneResponse() {
//
//        Airplane airplane = Airplane.builder()
//                .airplane_id(1L)
//                .model("Airbus A320")
//                .capacity(200)
//                .dateFabrication("2019-05-15")
//                .build();
//
//
//        AirplaneResponse response = airplaneMapper.toAirplaneResponse(airplane);
//
//        assertEquals(airplane.getAirplane_id(), response.airplane_id());
//        assertEquals(airplane.getModel(), response.model());
//        assertEquals(airplane.getCapacity(), response.capacity());
//        assertEquals(airplane.getDateFabrication(), response.dateFabrication());
//    }



}