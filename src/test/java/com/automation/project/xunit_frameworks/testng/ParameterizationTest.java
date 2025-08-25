package com.automation.project.xunit_frameworks.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationTest {
    static Logger logger = LogManager.getLogger(ParameterizationTest.class);

    @Parameters({"userName", "password"})
    @Test
    public void testLogin(String userName, String password) {
        logger.info("The username and password are :" + userName + " " + password);
        System.out.println(Thread.currentThread().getId());
    }


    @Test(dataProvider = "loginData")
    public void testLoginWithDp(String userName, String password) {
        logger.info("The username and password are :" + userName + "/" + password);
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void loginSucess() {
        logger.info("User is logged in sucessfully");
        System.out.println(Thread.currentThread().getId());
    }
    @DataProvider(name = "loginData")
    public Object[][] testLoginWithData() {
        return new Object[][]{{"John", "J24242"},
                {"Rekha", "R2242"},
                {"Marvel", "M33535"}
        };
    }
}
