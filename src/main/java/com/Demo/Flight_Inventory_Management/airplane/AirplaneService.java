package com.Demo.Flight_Inventory_Management.airplane;

import com.Demo.Flight_Inventory_Management.commonEntity.PageResponse;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
public class AirplaneService {

    private final AirplaneRepo airplaneRepo;
    private final AirplaneMapper airplaneMapper;



    public Long addAirplane(@Valid AirplaneRequest request, Authentication connectedUser) {

        User user = (User) connectedUser.getPrincipal();
        Airplane airplane = airplaneMapper.toAirplane(request);
        return airplaneRepo.save(airplane).getAirplane_id();
    }

    public AirplaneResponse findAirplaneById(Long airplaneId) {
        return airplaneRepo.findById(airplaneId)
                .map(airplaneMapper::toAirplaneResponse)
                .orElseThrow(()->new EntityNotFoundException("Airplane not found"));
    }

    public PageResponse<AirplaneResponse> findAllAirplane(int page, int size, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<Airplane> airplanes = airplaneRepo.findAll(pageable);
        List<AirplaneResponse> airplaneResponses = airplanes.stream()
                .map(airplaneMapper::toAirplaneResponse)
                .toList();
        return new PageResponse<>(
                airplaneResponses,
                airplanes.getNumber(),
                airplanes.getSize(),
                airplanes.getTotalElements(),
                airplanes.getTotalPages(),
                airplanes.isFirst(),
                airplanes.isLast());
    }

    public void deleteAirplaneById(Long airplaneId) {
        var airplane = airplaneRepo.findById(airplaneId)
                .orElseThrow(()->new EntityNotFoundException("Airplane not found"));
        airplaneRepo.delete(airplane);
    }
}
