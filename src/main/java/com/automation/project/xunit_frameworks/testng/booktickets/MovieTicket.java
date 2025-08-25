package com.automation.project.xunit_frameworks.testng.booktickets;

public class MovieTicket implements Ticket {

    @Override
    public int cost(int quantity) {
        return quantity * 150;
    }

}
