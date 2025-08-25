package com.automation.project.xunit_frameworks.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class InvocationCountAndTimeout {
    static Logger logger = LogManager.getLogger(InvocationCountAndTimeout.class);

    /*@Test
    public void testOnce() {
        logger.info("Running test once.");
    }*/

    @Test(invocationCount = 3)
    public void testTwice() {
        logger.info("Running test twice.");
    }

    @Test(invocationCount = 5, invocationTimeOut = 3000, threadPoolSize = 2)
    public void testThriceInGivenTime() throws InterruptedException {
//        sleep(1000);
        logger.info("Running test thrice in given time.");
//        logger.info(Thread.currentThread().getId());
    }
}
