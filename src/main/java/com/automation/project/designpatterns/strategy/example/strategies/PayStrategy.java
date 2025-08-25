package com.automation.project.designpatterns.strategy.example.strategies;

/**
 * EN: Common interface for all strategies.
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}

