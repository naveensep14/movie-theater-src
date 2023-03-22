package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTests {
    /**
     * Total fee for a reservation made by a customer
     */
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater();
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = Reservation.reserve(john, 2, 4, theater);
        assertEquals(reservation.totalFee(), 37.5);
    }

    /**
     * Checks if two same customer objects are equal
     */
    @Test
    void compareTwoSameCustomers() {
        var customerA = new Customer("John Doe", "unused-id");
        var customerB = new Customer("John Doe", "unused-id");
        assertEquals(customerA, customerB);
    }

    /**
     * Checks if two differ customer objects are not equal
     */
    @Test
    void compareTwoCustomersWithDiffId() {
        var customerA = new Customer("John Doe", "unused-id");
        var customerB = new Customer("John Doe", "used-id");
        assertNotEquals(customerA, customerB);
    }
}
