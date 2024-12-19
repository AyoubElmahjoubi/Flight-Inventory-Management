package com.Demo.Flight_Inventory_Management.user;

import com.Demo.Flight_Inventory_Management.admin.AdminResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getUserId())
                .fullName(user.fullName())
                .email(user.getEmail())
                .dateOfBirth(user.getBirthdate())
                .createdAt(user.getCreatedDate())
                .isEnabled(user.isEnabled())
                .isLocked(user.isAccountLocked())
                .build();
    }

    public AdminResponse toAdminResponse(User user) {
        return AdminResponse.builder()
                .id(user.getUserId())
                .fullName(user.fullName())
                .email(user.getEmail())
                .dateOfBirth(user.getBirthdate())
                .createdAt(user.getCreatedDate())
                .build();
    }
}
