package com.Demo.Flight_Inventory_Management.airplane;

import com.Demo.Flight_Inventory_Management.flight.Flight;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_id;
    private String model;
    private Integer capacity;
    private String dateFabrication;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @OneToOne(mappedBy = "airplane")
    private Flight flight;
}
