package com.automation.project.designpatterns.strategy.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrategyPatternTest {
    static Logger logger = LogManager.getLogger(StrategyPatternTest.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Travel travel = new Travel();

    public static void main(String[] args) throws IOException {
        System.out.print("Please enter distance:");
        int distance = Integer.parseInt(reader.readLine());
        travel.setDistance(distance);
        logger.info("Time taken to travel by car is: " + travel.findTravelTime(new TravelByCar()));
        logger.info("Time taken to travel by foot is: " + travel.findTravelTime(new TravelByFoot()));
        logger.info("Time taken to travel by two wheeler is: " + travel.findTravelTime(new TravelByTwoWheeler()));


    }
}
