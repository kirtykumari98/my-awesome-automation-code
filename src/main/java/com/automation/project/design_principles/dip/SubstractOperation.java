package com.automation.project.design_principles.dip;

public class SubstractOperation implements CalculatorOperation{
    @Override
    public double calculate(double a, double b) {
        return a-b;
    }
}
