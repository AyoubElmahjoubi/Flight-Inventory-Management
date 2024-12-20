package com.Demo.Flight_Inventory_Management.airport;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AirportRequest(

    Long id ,

    @NotEmpty
    @NotNull
    String airportName,

    @NotEmpty
    @NotNull
    String iaatCode,

    @NotEmpty
    @NotNull
    String city ,

    @NotEmpty
    @NotNull
    String country

) {
}
