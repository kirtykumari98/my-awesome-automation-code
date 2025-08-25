package com.automation.project.designpatterns.strategy.example;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TravelStrategy {
    float calculateTime(int distance);
}
