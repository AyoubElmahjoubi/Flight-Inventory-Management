package com.Demo.Flight_Inventory_Management.airplane;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneResponse {

    private Long airplane_id;
    private String model;
    private Integer capacity;
    private String dateFabrication;
}
