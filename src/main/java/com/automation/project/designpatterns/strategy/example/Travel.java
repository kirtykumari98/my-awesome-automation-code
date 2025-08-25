package com.automation.project.designpatterns.strategy.example;

public class Travel {

    private static int distance;

    public float findTravelTime(TravelStrategy strategy) {
        return strategy.calculateTime(distance);
    }

    public static int getDistance() {
        return distance;
    }

    public static void setDistance(int distance) {
        Travel.distance = distance;
    }
}
