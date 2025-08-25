package com.automation.project.selenium.basics;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowserExample {

    @Test
    public void testHeadlessModeChrome()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.get("https://www.facebook.com");
        System.out.println("the title of the page are "+driver.getTitle());

    }
    @Test
    public void testHeadlessModeFirefox()
    {
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions= new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        WebDriver driver= new FirefoxDriver(firefoxOptions);
        driver.get("https://www.facebook.com");
        System.out.println("the title of the page are "+driver.getTitle());

    }

    @Test
    public void testHtmlUnitDriver()
    {
        WebDriver driver= new HtmlUnitDriver(true);
        driver.get("https://www.facebook.com");
        System.out.println("the title of the page are "+driver.getTitle());
    }
    @Test
    public void testHtmlUnitDriverWithChrome()
    {
        WebDriver driver= new HtmlUnitDriver(BrowserVersion.CHROME,true);
        driver.get("https://www.facebook.com");
        System.out.println("the title of the page are "+driver.getTitle());
    }
}
