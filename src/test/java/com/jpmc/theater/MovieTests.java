package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTests {
    /**
     * Movie object with title, duration and running time
     */
    @Test
    void movieObject() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertEquals(12.5, spiderMan.getTicketPrice());
        assertEquals("Spider-Man: No Way Home", spiderMan.getTitle());
        assertEquals(Duration.ofMinutes(90), spiderMan.getRunningTime());
    }

    /**
     * Checks if two same movie objects are equal
     */
    @Test
    void compareTwoSameMovies() {
        var movieA = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        var movieB = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertEquals(movieA, movieB);
    }

    /**
     * Checks if two different movie objects are not equal
     */
    @Test
    void compareTwoMoviesWithDiffSpecialCode() {
        var movieA = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        var movieB = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        assertNotEquals(movieA, movieB);
    }

}
