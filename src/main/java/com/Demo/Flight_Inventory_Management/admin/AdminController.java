package com.Demo.Flight_Inventory_Management.admin;

import com.Demo.Flight_Inventory_Management.user.UserRepository;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "admin")
public class AdminController {

    private final AdminService service ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register-admin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?>registerAdmin(
            @Valid @RequestBody AdminRegistrationRequest request )throws MessagingException {
        service.registerAdmin(request );
        return ResponseEntity.accepted().build();
    }
}
