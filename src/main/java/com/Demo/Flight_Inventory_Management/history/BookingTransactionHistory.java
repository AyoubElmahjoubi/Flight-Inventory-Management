package com.Demo.Flight_Inventory_Management.history;

import com.Demo.Flight_Inventory_Management.bookingFlight.Booking;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookingTransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
    @ManyToOne
    @JoinColumn( name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    private boolean isConfirmed;
    private boolean isConceled;



}
