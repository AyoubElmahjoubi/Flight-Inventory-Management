package com.Demo.Flight_Inventory_Management.flight;

import com.Demo.Flight_Inventory_Management.airplane.Airplane;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record FlightRequest(

    Long id,
    @NotEmpty(message = "110")
    @NotNull(message = "110")
    String flightNumber,

    @NotEmpty(message = "111")
    @NotNull(message = "111")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime departureTime,

    @NotEmpty(message = "112")
    @NotNull(message = "112")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime arrivalTime,

    @NotEmpty(message = "113")
    @NotNull(message = "113")
    double basePrice,

    @NotEmpty(message = "114")
    @NotNull(message = "114")
    Long departureFromId,

    @NotEmpty(message = "115")
    @NotNull(message = "115")
    Long arrivalToId,

    @NotEmpty(message = "116")
    @NotNull(message = "116")
    int numberOfSeats,

    @NotEmpty(message = "117")
    @NotNull(message = "117")
    Long airplaneId,

    String flightClass,

    String flightEscale,

    String program,

    @NotEmpty(message = "118")
    @NotNull(message = "118")
    double bagageCapacity,

    @NotEmpty(message = "120")
    @NotNull(message = "120")
    double CabinCapacity


) {
}
