package com.Demo.Flight_Inventory_Management.airplane;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AirplaneRequest(


        Long id,

        @NotEmpty
        @NotNull
        String model,

        @NotEmpty
        @NotNull
        int capacity,

        @NotEmpty
        @NotNull
        String dateFabrication
) {
}
