package com.automation.project.xunit_frameworks.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


public class OrderOfExecution {
    static Logger logger = LogManager.getLogger(OrderOfExecution.class);


    @BeforeSuite
    private void setupBeforeSuite() {
        logger.info("Setup something before running suite.");
    }


    @BeforeClass
    public void setupBeforeClass() {
        logger.info("Setup to be done before running every class");
    }


    @BeforeGroups("broken")
    public void runBeforeGroups() {
        logger.info("Running before groups to see if there is something to exclude");
    }


    @BeforeMethod
    public void runBeforeMethod() {
        logger.info("running before method");
    }


    @BeforeTest
    public void runBeforeTest() {
        logger.info("running before test");
    }

    // test methods

    @Test (groups = "broken")
    public void testTheSequence() {
        logger.info("Testing the sequence of annotations");
    }

    /*@Test
    public void testTheOrderOfExecution() {
        logger.info("Testing the order of execution");
    }

    @Test
    public void testSomethingElse() {
        logger.info("Testing something else.");
    }*/

    @AfterTest
    public void runAfterTest() {
        logger.info("running after test");
    }


    @AfterMethod
    public void runAfterMethod() {
        logger.info("running after method");
    }

    @AfterClass
    public void runAfterClass() {
        logger.info("running after class");
    }

    @AfterGroups("broken")
    public void afterGroups() {
        logger.info("running after groups");
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("running after Suite");
    }
}
