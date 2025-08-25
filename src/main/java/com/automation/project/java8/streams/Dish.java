package com.automation.project.java8.streams;

import java.util.Arrays;
import java.util.List;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEALS, BREAKFAST, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("biryani", false, 800, Type.MEALS),
                           new Dish("rajma chawal", false, 200, Type.MEALS),
                           new Dish("dal makhni", false, 300, Type.MEALS),
                           new Dish("curd rice", true, 530, Type.OTHER),
                           new Dish("burger", true, 543, Type.OTHER),
                           new Dish("pasta", true, 500, Type.OTHER),
                           new Dish("pizza", true, 550, Type.OTHER),
                           new Dish("idli", false, 100, Type.BREAKFAST),
                           new Dish("dosa", false, 200, Type.BREAKFAST));
}