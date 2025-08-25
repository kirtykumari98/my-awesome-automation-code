package com.automation.project.xunit_frameworks.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Example extends ConfigurationTest{
    static Logger logger = LogManager.getLogger(Example.class.getName());
    Object object = new Object();

    @Override
    public String toString() {
        return "Example{" +
                "object=" + object +
                '}';
    }

    @Test
    public void exampleTest() {
        logger.info("I am the object: " + object.toString());
    }

    @Test
    public void secondExampleTest() {
        logger.info("I am object: " + object.toString());
    }

}
