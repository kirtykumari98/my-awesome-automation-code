package com.automation.project.java8.streams;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class DebuggingStreams {
    static Logger logger= LogManager.getLogger(DebuggingStreams.class);
    public static void main(String[] args) {

      List<Dish> dishes=  Dish.menu.stream().filter(d -> {
          logger.log(Level.INFO,"filtering "  + d.getName());
//                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }
}
