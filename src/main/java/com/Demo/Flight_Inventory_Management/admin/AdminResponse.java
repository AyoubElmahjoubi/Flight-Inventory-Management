package com.Demo.Flight_Inventory_Management.admin;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AdminResponse {

    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
}
