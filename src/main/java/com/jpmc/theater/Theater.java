package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.StringBuilder;


public class Theater {

    private List<Showing> schedule;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

    public Theater() {

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        schedule = List.of(
                new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))),
                new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0))),
                new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50))),
                new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))),
                new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 10))),
                new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 50))),
                new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30))),
                new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10))),
                new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 0)))
        );
    }

    public List<Showing> getSchedule() {
        return schedule;
    }


    public void printSchedule() {
        System.out.println(LocalDate.now());
        System.out.println("===================================================");
        for (Showing show : schedule) {
            StringBuilder sb = new StringBuilder();
            sb.append(show.getSequenceOfTheDay()).append(": ").append(show.getStartTime().format(formatter)).
                    append(" ").append(show.getMovie().getTitle()).append(" ").append(humanReadableFormat(show.getMovie().getRunningTime())).
                    append(" $").append(show.getMovieFee());

            System.out.println(sb.toString());
        }

        System.out.println("===================================================");
    }

    public void printScheduleInJsonFormat() {

        JSONArray showings = new JSONArray();

        for (Showing show : schedule) {
            JSONObject movieObj = new JSONObject();
            movieObj.put("sequence", show.getSequenceOfTheDay());
            movieObj.put("startTime", show.getStartTime().format(formatter));
            movieObj.put("title", show.getMovie().getTitle());
            movieObj.put("runningTime", humanReadableFormat(show.getMovie().getRunningTime()));
            movieObj.put("ticketPrice", show.getMovieFee());
            showings.put(movieObj);
        }

        JSONObject rootObj = new JSONObject();
        rootObj.put("date", LocalDate.now());
        rootObj.put("showings", showings);

        // Printing the created json.
        System.out.println(showings.toString(4));
    }

    // Formats duration of the movie into readable string like ex: (1 hour 35 minutes)
    public String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        } else {
            return "s";
        }
    }

    public static void main(String[] args) {
        Theater theater = new Theater();
        theater.printSchedule();
    }
}
