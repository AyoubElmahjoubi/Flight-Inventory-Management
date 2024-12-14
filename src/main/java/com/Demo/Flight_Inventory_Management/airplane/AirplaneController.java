package com.Demo.Flight_Inventory_Management.airplane;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airplane")
@Tag(name = "Airplane")
public class AirplaneController {


    private final AirplaneService service ;

    @PostMapping("/add-airplane")
    public ResponseEntity<Long> addAirplane(
            @Valid @RequestBody AirplaneRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addAirplane(request,connectedUser));
    }
}
