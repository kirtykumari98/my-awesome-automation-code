package com.automation.project.java8.predicates;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {


        Predicate<String> nonEmpty=(String s)->!s.isEmpty();
    }
}
