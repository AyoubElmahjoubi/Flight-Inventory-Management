package com.Demo.Flight_Inventory_Management.airport;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportMapper airportMapper;

    private final AirportRepo airportRepository;

    public Long addAirport(AirportRequest request, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Airport airport = airportMapper.toAirport(request);
        return airportRepository.save(airport).getAirport_id();
    }

    public AirportResponse findById(Long airportId) {
        return airportRepository.findById(airportId)
                .map(airportMapper::toAirpotResponse)
                .orElseThrow(()-> new EntityNotFoundException("Airport with this ID"+airportId+"not found"));
    }

    public PageResponse<AirportResponse> findAllAirport(int page, int size, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<Airport> airports = airportRepository.findAll(pageable);
        List<AirportResponse> airportResponses = airports.stream()
                .map(airportMapper::toAirpotResponse)
                .toList();
        return new PageResponse<>(
                airportResponses,
                airports.getNumber(),
                airports.getSize(),
                airports.getTotalElements(),
                airports.getTotalPages(),
                airports.isFirst(),
                airports.isLast()
        );
    }

    public void deleteById(Long airportId) {
        var airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new EntityNotFoundException("Airport with this ID"+airportId+"not found"));
        airportRepository.delete(airport);

    }
}
