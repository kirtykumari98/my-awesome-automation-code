package com.automation.project.xunit_frameworks.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DependsOnTest {
    static Logger logger = LogManager.getLogger(DependsOnTest.class);


    //Depends on Groups
    @Test(dependsOnGroups = "database setup",groups = "execute queries")
    public void executeDataBaseQuery() {
        logger.info("executing database queries");
    }

    @Test(groups = "database setup" )
    public void setupDatabaseConnection() {
        logger.info("Setting up database connection");
    }
    @Test(groups = "database setup", dependsOnMethods = "setupDatabaseConnection")
    public void prepareStatement() {
        logger.info("preparing the statement");
    }

    //Depends on Methods

    @Test(dependsOnMethods = "login")
    public void testHomePage() {
        logger.info("Testing home page");
    }

    @Test
    public void login() {
        logger.info("Logging into the application");
    }
}
