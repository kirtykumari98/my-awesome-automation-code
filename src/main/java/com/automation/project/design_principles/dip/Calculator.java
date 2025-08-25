package com.automation.project.design_principles.dip;

public class Calculator { //high-level module
    CalculatorOperation calculatorOperation;

    public Calculator(CalculatorOperation calculatorOperation) {
        this.calculatorOperation = calculatorOperation;
    }

    public double solve(double a, double b) {
        return calculatorOperation.calculate(a, b);
    }

}
