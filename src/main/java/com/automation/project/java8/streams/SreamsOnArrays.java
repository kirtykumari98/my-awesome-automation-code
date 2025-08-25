package com.automation.project.java8.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SreamsOnArrays {

    public static void main(String[] args) {
        Dish [] dishes= {new Dish("idli",true,34, Dish.Type.BREAKFAST)
                ,new Dish("Masala Dosa",true,57, Dish.Type.BREAKFAST)
                ,new Dish("Dum Biryani",false,156, Dish.Type.MEALS)};
        Arrays.stream(dishes).filter(d->!d.isVegetarian())
                .filter(d->d.getType().equals(Dish.Type.MEALS))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
