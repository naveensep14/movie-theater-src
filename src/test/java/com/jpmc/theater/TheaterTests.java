package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    /**
     * Prints movie schedule in simple text
     */
    @Test
    void printMovieSchedule() {
        Theater theater = new Theater();
        theater.printSchedule();
    }
    /**
     * Prints movie schedule in JSON format with indentation
     */
    @Test
    void printScheduleInJsonFormat() {
        Theater theater = new Theater();
        theater.printScheduleInJsonFormat();
    }

    /**
     * Checks if duration is converted to human-readable format
     */
    @Test
    void humanReadableFormatOfDuration() {
        Theater theater = new Theater();
        LocalTime start = LocalTime.of(10, 30, 0, 0);
        LocalTime end = LocalTime.of(12, 0, 0, 0);
        assertEquals("(1 hour 30 minutes)", theater.humanReadableFormat(Duration.between(start, end)));
    }

    /**
     * Check is plurals are handled in duration's formatted string
     */
    @Test
    void humanReadableFormatOfPluralDuration() {
        Theater theater = new Theater();
        LocalTime start = LocalTime.of(10, 30, 0, 0);
        LocalTime end = LocalTime.of(13, 0, 0, 0);
        assertEquals("(2 hours 30 minutes)", theater.humanReadableFormat(Duration.between(start, end)));
    }
}
