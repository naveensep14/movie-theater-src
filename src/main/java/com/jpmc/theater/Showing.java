package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private static int MOVIE_CODE_SPECIAL = 1;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public double getMovieFee() {
        return movie.getTicketPrice() - getDiscount(sequenceOfTheDay, showStartTime);
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    /**
     *
     * @param showSequence se
     * @param startTime
     * @return
     */
    private double getDiscount(int showSequence, LocalDateTime startTime) {
        double specialDiscount = 0;
        double startTimeDiscount = 0;
        double ticketPrice = movie.getTicketPrice();

        if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        if (startTime.getHour() >= 11 && startTime.getHour() <= 16) {
            startTimeDiscount = ticketPrice * 0.25; // 25% discount for shows starting between 11AM ~ 4pm
        }

        double sequenceDiscount = getSequenceDiscount(showSequence);

        // Applying only the biggest amount discount
        double maxDiscount = Math.max(specialDiscount, Math.max(startTimeDiscount, sequenceDiscount));

        // If discount is greater than ticket price return ticket price as discount cannot exceed ticket price
        return maxDiscount > ticketPrice ? ticketPrice : maxDiscount;
    }

    private double getSequenceDiscount(int showSequence) {
        double sequenceDiscount = 0;
        switch (showSequence) {
            case 1:
                sequenceDiscount = 3; // $3 discount for 1st show
                break;
            case 2:
                sequenceDiscount = 2; // $2 discount for 2nd show
                break;
            case 7:
                sequenceDiscount = 1; // $1 discount for 7th show
                break;
            default:
                // If none of the above cases are met, do nothing
                break;
        }
        return sequenceDiscount;
    }
}
