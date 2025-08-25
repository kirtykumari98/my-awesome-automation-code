package com.automation.project.bdd_in_action.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String browser)
    {
        switch (browser)
        {
            case "chrome":
               WebDriverManager.chromedriver().setup();
               driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

        }
        driver.manage().window().maximize();
    }
}
