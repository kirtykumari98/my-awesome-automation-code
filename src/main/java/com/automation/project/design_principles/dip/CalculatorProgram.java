package com.automation.project.design_principles.dip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorProgram {
    static Logger logger = LogManager.getLogger(CalculatorProgram.class);

    public void addSample() {
        Calculator calculator = new Calculator(new AddOperation());
        logger.info("The addition of two numbers " + calculator.solve(3.0, 5.0));
    }

    public void subtractSample() {
        Calculator calculator = new Calculator(new SubstractOperation());
        logger.info("The subtraction of two numbers " + calculator.solve(3.0, 5.0));
    }

    public void divideSample() {
        Calculator calculator = new Calculator(new DivideOperation());
        logger.info("The division of two numbers " + calculator.solve(3.0, 5.0));
    }

    public static void main(String[] args) {
        CalculatorProgram program = new CalculatorProgram();
        program.addSample();
        program.subtractSample();
        program.divideSample();

    }
}
