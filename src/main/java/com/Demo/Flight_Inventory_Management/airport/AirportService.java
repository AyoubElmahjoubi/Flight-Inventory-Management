package com.Demo.Flight_Inventory_Management.airport;

import com.Demo.Flight_Inventory_Management.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {

    @Autowired
    private AirportMapper airportMapper;

    @Autowired
    private AirportRepo airportRepository;

    public Long addAirport(AirportRequest request, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Airport airport = airportMapper.toAirport(request);
        return airportRepository.save(airport).getAirport_id();
    }
}
