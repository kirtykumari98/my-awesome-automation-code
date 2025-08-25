package com.automation.project.selenium.advanced.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackTestBase {

    public static final String BROWSERSTACK_USERNAME = "sharadadoddi_cUVMd5";
    public static final String BROWSERSTACK_ACCESS_KEY = "HP5eY4gepvgkjVX54cpn";
    public static final String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "os"})
    public void setup(@Optional("chrome") String browser, @Optional("Windows") String osName) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion","latest");
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", osName);
        capabilities.setCapability("bstack:options", browserstackOptions);

        driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
