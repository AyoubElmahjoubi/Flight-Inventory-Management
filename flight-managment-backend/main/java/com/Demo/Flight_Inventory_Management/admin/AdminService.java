package com.Demo.Flight_Inventory_Management.admin;

import com.Demo.Flight_Inventory_Management.role.RoleRepository;
import com.Demo.Flight_Inventory_Management.user.User;
import com.Demo.Flight_Inventory_Management.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public void registerAdmin(AdminRegistrationRequest request) {
        var adminRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new IllegalStateException("Admin Role not found or not initialized"));
        var admin = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(true)
                .roles(List.of(adminRole))
                .build();
        userRepository.save(admin);
    }
}
