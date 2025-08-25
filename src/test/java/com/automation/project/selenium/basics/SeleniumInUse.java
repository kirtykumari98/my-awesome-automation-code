package com.automation.project.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SeleniumInUse {

    private static WebDriver driver;
    private  WebDriverWait wait;

    @BeforeSuite
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sharada_Doddi\\Documents\\RD_Batch_Training\\Automation testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void openBrowser()
    {
        driver.get("http://www.google.com");

        System.out.println("the title of the web page is  "+driver.getTitle());
    }

    @Test
    public void browserNavigations()
    {
        driver.get("https://www.google.com");
//       driver.findElement(By.name("qq"));//invalid

       List<WebElement> searchTextElements= driver.findElements(By.name("qq"));
       assertTrue(searchTextElements.size()>0);
    }

    @Test
    public void moreBrowserFunctions() {
        driver.navigate().to("https://www.facebook.com");
        System.out.println("current url is " + driver.getCurrentUrl());
//        System.out.println("the page source of current webpage is "+driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));
        System.out.println("window handle for current window"+driver.getWindowHandle());
        driver.navigate().to("https://www.google.com");
        System.out.println("window handle for current window"+driver.getWindowHandle());
        String currentHandle= driver.getWindowHandle();

        System.out.println("get window handles "+driver.getWindowHandles());
        //CDwindow-59E5D823FBB39FD0EAD840C62FE031DA,CDwindow-59E5D823FBB39FD0EAD840C62FE031DB -
        for(String handle:driver.getWindowHandles())
        {
            if(!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }
    }

    @Test
    public void searchSomething() {
        driver.navigate().to("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        List<WebElement> elements = driver.findElements(By.className("gb_d"));
        for (WebElement ele : elements) {
            System.out.println(ele.getText());
        }
        WebElement searchButton= driver.findElement(By.name("btnK"));
        assertFalse(searchButton.isDisplayed());
        System.out.println(searchButton.getAttribute("value"));
//        assertFalse(searchButton.isEnabled());
        WebElement imagesLink= driver.findElement(By.cssSelector("[href='https://www.google.co.in/imghp?hl=en&ogbl']"));
//        assertFalse(imagesLink.isDisplayed());
        System.out.println(imagesLink.getSize());
        System.out.println("The size of input element is "+driver.findElement(By.name("q")).getSize());
        System.out.println(imagesLink.getCssValue("color"));
//        assertFalse(imagesLink.isEnabled());
    }


    @Test
    public void switchToAnotherTab() throws AWTException, InterruptedException {
        driver.get("https://www.google.com");
        String currentHandle = driver.getWindowHandle();
        System.out.println("hash for the current handle is "+ Objects.hash(currentHandle));
        System.out.println("Before new tab is opened "+currentHandle);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        String currentHandleAfterNewTab= driver.getWindowHandle();
        System.out.println("After new tab is opened "+currentHandleAfterNewTab);
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for (String handle : handles) {
            System.out.println("hash for the current handle from set is "+ handle+" "+Objects.hash(handle));
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.get("https://www.facebook.com");

    }

    @Test
    public void isDisplayedTest()
    {
        driver.get("https://www.google.com");
        List<WebElement> searchButtons= driver.findElements(By.name("btnK"));
        System.out.println(searchButtons.get(1).getSize());
        System.out.println("The location of google search button is "+searchButtons.get(1).getLocation());
        assertFalse(searchButtons.get(1).isDisplayed());
    }


   /* @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }*/


}
