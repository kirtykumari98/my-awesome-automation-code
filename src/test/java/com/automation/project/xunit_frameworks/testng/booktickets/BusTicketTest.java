package com.automation.project.xunit_frameworks.testng.booktickets;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class BusTicketTest {
    Ticket ticket;

    @BeforeClass
    public void setUp() {
        ticket = new BusTicket();
    }

    @Test(description = "test the cost of a ticket")
    public void testCost() {

        assertEquals(ticket.cost(3), 3000, "The ticket cost for quantity 3 is ");
        assertEquals(ticket.cost(10), 1000, "The ticket cost for quantity 10 is ");
    }
}