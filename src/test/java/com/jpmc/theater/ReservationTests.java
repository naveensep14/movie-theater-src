package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTests {
    /**
     * Calculate total fee based on showing and ticket count
     */
    @Test
    void totalReservationFee() {
        var theater = new Theater();
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 00, 30, 0))
        );
        assertEquals(28.5, new Reservation(customer, showing, 3, theater).totalFee());
    }

    /**
     * Throws IllegalArgumentException when showing sequence number is invalid
     */
    @Test
    void invalidReservation() {
        var theater = new Theater();
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                11,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 00, 30, 0))
        );
        assertThrows(IllegalArgumentException.class, () -> Reservation.reserve(customer, showing.getSequenceOfTheDay(), 3, theater));
    }
}
