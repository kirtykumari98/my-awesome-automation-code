package com.automation.project.designpatterns.strategy.example;

public class TravelByTwoWheeler implements TravelStrategy{
    @Override
    public float calculateTime(int distance) {
        return distance/60;
    }
}
