package com.automation.project.java8.multicore;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessorJava8 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 10, 9, 3, 2, 1, 1, 0);
        List<Integer> squaredIntegers = integers.stream()
                .map(x->{
                    System.out.println("mapping "+x*x);
                        return  x * x;
                })
                .collect(Collectors.toList());
        System.out.println(squaredIntegers);
    }
}
