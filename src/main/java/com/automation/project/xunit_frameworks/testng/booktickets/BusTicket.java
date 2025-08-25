package com.automation.project.xunit_frameworks.testng.booktickets;

public class BusTicket implements Ticket {
    @Override
    public int cost(int quantity) {
        return quantity * 1000;
    }
}
