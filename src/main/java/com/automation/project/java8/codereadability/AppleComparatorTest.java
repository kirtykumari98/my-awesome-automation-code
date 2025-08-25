package com.automation.project.java8.codereadability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleComparatorTest {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(5, "red"));
        apples.add(new Apple(7, "green"));
        apples.add(new Apple(2, "dark red"));
        apples.add(new Apple(1, "green"));

//        Collections.sort(apples, new AppleWeightComparator());
       

        /*Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });

        for (Apple apple : apples) {
//            System.out.print(apple.getWeight() + " " +apple.getColor()+ " ");
            System.out.println(apple.getWeight() + " " +apple.getColor()+ " ");
        }*/

        // First Approach
        Comparator<Apple> byWeight =

                (Apple a1, Apple a2) -> a1.getWeight()-(a2.getWeight());

        apples.sort(byWeight);

       //Method references
//        1.
        apples.sort(Comparator.comparing(Apple::getWeight));


        apples.stream().filter(a->"green".equals(a.getColor()));
        for(Apple a:apples)
        {

        }
        //Predicates Example
        List<Apple> greenApples = filter(apples, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> heavyApples = filter(apples, (Apple a) -> a.getWeight()>5);
        List<Apple> redApples = filter(apples, (Apple a) -> "red".equals(a.getColor()));
        for (Apple apple : heavyApples) {
//            System.out.print(apple.getWeight() + " " +apple.getColor()+ " ");
            System.out.println(apple.getWeight() + " " +apple.getColor()+ " ");
        }
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;

    }




}
