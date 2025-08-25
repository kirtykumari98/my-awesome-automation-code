package com.automation.project.design_principles.dip;

public class CalculatorViolatingDip {
    public double add(double a, double b) {
        return a + b;
    }

    public double substract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b){return a*b;}
}
