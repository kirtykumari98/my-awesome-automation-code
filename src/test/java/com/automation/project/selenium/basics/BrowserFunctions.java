package com.automation.project.selenium.basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserFunctions {

    private static WebDriver driver;

    @BeforeSuite
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sharada_Doddi\\Documents\\RD_Batch_Training\\Automation testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void verifyGoogleWebPageIsOpened() {
        driver.get("https://www.google.com");
        driver.getTitle().equals("Google");
    }

    @Test
    void maximizeTheBrowser() {
        Dimension dimension = new Dimension(1080, 1080);
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyBrowserOperations() {
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }

    @Test
    public void javaScriptUsage() {
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
        WebElement email = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementById('email');");
        email.sendKeys("909090000");
    }

    @Test(dependsOnMethods = {"verifyGoogleWebPageIsOpened"})
    public void searchSomeTextOnGooglePage() {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys("com/rd/training/selenium");
        searchText.sendKeys(Keys.ENTER);
    }

    @AfterSuite
    public void closeSession() {
        driver.close();
    }

}
