package com.Demo.Flight_Inventory_Management.bookingFlight;

import com.Demo.Flight_Inventory_Management.email.EmailService;
import com.Demo.Flight_Inventory_Management.flight.Flight;
import com.Demo.Flight_Inventory_Management.flight.FlightRepo;
import com.Demo.Flight_Inventory_Management.user.User;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingFlightService {

    private final BookingMapper bookingMapper;
    private final BookingRepo bookingRepo;
    private final FlightRepo flightRepo;
    private final EmailService emailService ;

    public Long saveBooking( BookingRequest request, Authentication connectedUser) {

        Flight flight = flightRepo.findById(request.flightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));

        User user = (User) connectedUser.getPrincipal();
        Booking booking = bookingMapper.toBooking(request,flight);
        booking.setBookedBy(user);
        booking.totalPrice();
        return bookingRepo.save(booking).getBookingId();
    }

    public boolean processPayment(PaymentRequest paymentRequest, Authentication connectedUser) {
        Booking booking = bookingRepo.findById(paymentRequest.bookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        boolean paymentSuccess = fakePaymentProcess(paymentRequest);

        if (paymentSuccess) {
            booking.setStatus(BookingStatus.CONFIRMEE);
            bookingRepo.save(booking);

            try {
                emailService.sendTicketEmail(
                        booking.getPassengerEmail(),
                        booking.getPassengerFirstName(),
                        booking.getBookingId(),
                        booking.getFlight().getFlight_departure(),
                        booking.getFlight().getFlight_arrival(),
                        booking.getFlight().getFlightNumber(),
                        booking.getNumberOfSeats(),
                        "Ticket de votre Vol"
                );
            } catch (MessagingException e) {
                log.error("Failed to send ticket email", e);
            }
        }

        return paymentSuccess;
    }

    private boolean fakePaymentProcess(PaymentRequest paymentRequest) {
        return true;
    }
}
