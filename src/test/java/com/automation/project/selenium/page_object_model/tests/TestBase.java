package com.automation.project.selenium.page_object_model.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                capabilities.setBrowserName("chrome");

                break;
            case "firefox":
                capabilities.setBrowserName("firefox");
                break;
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        /*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();*/
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.facebook.com");
    }
   @AfterMethod
    public void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(screenshot, new File(System.getProperty("user.dir") + "/test-output/screenshots"));
        Reporter.log("<a href='" + screenshot.getAbsolutePath() + "'> <img src= '" + screenshot.getAbsolutePath() + "' height='200' width='200'/></a>");

    }
    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
