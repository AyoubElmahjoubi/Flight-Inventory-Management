package com.Demo.Flight_Inventory_Management.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private boolean isEnabled;
    private boolean isLocked;

}
