package com.Demo.Flight_Inventory_Management.airplane;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airplane")
@Tag(name = "Airplane")
public class AirplaneController {


    private final AirplaneService service ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-airplane")
    public ResponseEntity<Long> addAirplane(
            @Valid @RequestBody AirplaneRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.addAirplane(request,connectedUser));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{airplane-id}")
    public ResponseEntity<AirplaneResponse>findAirplaneById(
            @PathVariable("airplane-id") Long airplaneId
    ){
        return ResponseEntity.ok(service.findAirplaneById(airplaneId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-airplane")
    public ResponseEntity<PageResponse<AirplaneResponse>>findAllAirplane(
            @RequestParam(name = "page" ,defaultValue = "0", required = false)int page,
            @RequestParam(name = "size" ,defaultValue = "5", required = false)int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllAirplane(page,size,connectedUser));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{airplane-id}")
    public ResponseEntity<Void> deleteFlightById(
            @PathVariable("airplane-id") Long airplaneId
    ) {
        service.deleteAirplaneById(airplaneId);
        return ResponseEntity.noContent().build();
    }
}
