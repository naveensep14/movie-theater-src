package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTests {
    /**
     * 20% percent discount is applied for special movie
     */
    @Test
    void movieTicketPriceAndTitle() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertEquals(12.5, spiderMan.getTicketPrice());
    }

    @Test
    void compareTwoSameMovies() {
        var movieA = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        var movieB = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertEquals(movieA, movieB);
    }

    @Test
    void compareTwoMoviesWithDiffSepcialCode() {
        var movieA = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        var movieB = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertNotEquals(movieA, movieB);
    }

}
