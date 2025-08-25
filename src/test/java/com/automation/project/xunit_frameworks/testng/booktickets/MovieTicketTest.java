package com.automation.project.xunit_frameworks.testng.booktickets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class MovieTicketTest {

    Ticket ticket;

    @BeforeMethod
    public void setUp() {
        ticket = new MovieTicket();
    }

    @Test
    public void testCost() {
        assertEquals(ticket.cost(2), 300, "The cost of 2 movie tickets is");
        assertEquals(ticket.cost(20), 3000, "The cost of 20 movie tickets is");
    }
    @Test(groups = "run test")
    public void testCostNegative()

    {
        assertEquals(ticket.cost(-20), -3000, "The cost of -20 movie tickets is");
    }

}