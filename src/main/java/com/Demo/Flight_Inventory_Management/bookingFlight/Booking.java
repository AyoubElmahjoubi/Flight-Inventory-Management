package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.Demo.Flight_Inventory_Management.flight.Flight;
import com.Demo.Flight_Inventory_Management.history.BookingTransactionHistory;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String passengerIdentityId ;
    private String passengerPassportId;
    private Date bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status ;

    private int numberOfSeats;

    private double total_price;

    @PrePersist
    protected void totalPrice() {
        if(flight != null) {
            this.total_price = numberOfSeats * flight.getBasePrice();
        }
    }
    @ManyToOne
    @JoinColumn(name = "bookedBy")
    private User bookedBy;

    @OneToMany(mappedBy = "booking")
    private List<BookingTransactionHistory> histories ;

}
