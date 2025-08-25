package com.automation.project.bdd_in_action.stepdefinition;

import com.automation.project.bdd_in_action.base.BaseTest;
import com.epam.reportportal.service.ReportPortal;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;


public class ServiceHooks {
    static BaseTest baseTest;
    Logger logger= LogManager.getLogger(ServiceHooks.class);

    @BeforeAll
    public static void initializeBrowser() {
        baseTest = new BaseTest();
        baseTest.openBrowser("chrome");
    }

    @AfterStep
    public void captureScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) baseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(screenshot, new File(System.getProperty("user.dir") + "src/main/resources/screenshots"));
        ReportPortal.emitLog("this a screenshot for scenario ---> " + scenario.getName(), "INFO", Calendar.getInstance().getTime(), screenshot);
    }

    @AfterAll
    public static void tearDown() {
        baseTest.driver.quit();
    }
}
