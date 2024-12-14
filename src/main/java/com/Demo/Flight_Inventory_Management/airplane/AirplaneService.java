package com.Demo.Flight_Inventory_Management.airplane;

import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneService {

    private final AirplaneRepo airplaneRepo;
    private final AirplaneMapper airplaneMapper;



    public Long addAirplane(@Valid AirplaneRequest request, Authentication connectedUser) {

        User user = (User) connectedUser.getPrincipal();
        Airplane airplane = airplaneMapper.toAirplane(request);
        return airplaneRepo.save(airplane).getAirplane_id();
    }
}
