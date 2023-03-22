package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private Theater theater;
    private int ticketCount;

    /**
     *
     * @param customer customer
     * @param showing showing
     * @param ticketCount ticket count
     * @param theater theater
     */
    public Reservation(Customer customer, Showing showing, int ticketCount, Theater theater) {
        this.customer = customer;
        this.showing = showing;
        this.ticketCount = ticketCount;
        this.theater = theater;
    }

    public double totalFee() {
        return showing.getMovieFee() * ticketCount;
    }

    /**
     *
     * @param customer customer
     * @param sequence sequence
     * @param ticketCount ticket count
     * @param theater
     * @return
     */
    public static Reservation reserve(Customer customer, int sequence, int ticketCount, Theater theater) {
        Showing showing;

        if(sequence < 0 || sequence > theater.getSchedule().size()) {
            throw new IllegalArgumentException("Unable to find any showing for given sequence " + sequence);
        }
        showing = theater.getSchedule().get(sequence - 1);

        return new Reservation(customer, showing, ticketCount, theater);
    }
}