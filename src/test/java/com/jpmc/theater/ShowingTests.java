package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowingTests {
    /**
     * 20% percent discount is applied for special movie
     */
    @Test
    void specialShowWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 00, 30, 0)));
        assertEquals(10, showing.getMovieFee());
    }

    /**
     * $3 discount is applied for 1st show
     */
    @Test
    void threeDollarDiscountFor1stShow() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 00, 30, 0)));
        assertEquals(9.5, showing.getMovieFee());
    }

    /**
     * $2 discount is applied for 2nd show
     */
    @Test
    void twoDollarDiscountFor2ndShow() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 00, 30, 0)));
        assertEquals(10.5, showing.getMovieFee());
    }

    /**
     * $1 discount is applied for 7th show
     */
    @Test
    void oneDollarDiscountFor7thShow() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 00, 30, 0)));
        assertEquals(11.5, showing.getMovieFee());
    }

    /**
     * Special movie discount with start time based discount. The biggest discount is applied.
     */
    @Test
    void specialMovieWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 00, 30, 0)));
        // should only consider the biggest discount
        assertEquals(9.375, showing.getMovieFee());
    }

    /**
     * Ticket price is lower than discount. Ticket price is set to zero instead of negative value.
     */
    @Test
    void movieWithTicketPriceLowerThanDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),2, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 00, 30, 0)));
        assertEquals(0, showing.getMovieFee());
    }
}
