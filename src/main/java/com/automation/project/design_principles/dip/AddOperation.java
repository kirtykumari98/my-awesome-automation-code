package com.automation.project.design_principles.dip;

public class AddOperation implements CalculatorOperation{ //low-level module
    @Override
    public double calculate(double a, double b) {
        return a+b;
    }
}
