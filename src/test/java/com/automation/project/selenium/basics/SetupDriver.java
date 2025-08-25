package com.automation.project.selenium.basics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class SetupDriver {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeClass(groups = "chrome")
    public void setupChrome()
    {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @BeforeClass(groups = "firefox",enabled = false)
    public void setupFirefox()
    {
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterClass
    public void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(screenshot,new File(System.getProperty("user.dir")+"/test-output/screenshots"));
        Reporter.log("<a href='"+screenshot.getAbsolutePath()+"'> <img src= '"+screenshot.getAbsolutePath()+"' height='200' width='200'/></a>");

    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
