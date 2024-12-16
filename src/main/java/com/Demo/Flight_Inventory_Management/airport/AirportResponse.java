package com.Demo.Flight_Inventory_Management.airport;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportResponse {

    private long airport_id;
    private String airport_name;
    private String iata_code;
    private String city;
    private String country;
}
