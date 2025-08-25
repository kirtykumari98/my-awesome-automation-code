package com.automation.project.selenium.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AlertsTested {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testAlertPopup() {
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("the text in alert window is "+alert.getText());
        alert.accept();
    }

    @Test
    public void testAlertConfirm() {
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("the text in alert window is "+alert.getText());
        alert.dismiss();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        assertEquals(result.getText(), "You clicked: Cancel", "The result is not as expected");
    }

    @Test
    public void testAlertPrompt() {
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Testing js prompt with selenium");
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        assertEquals(result.getText(), "You entered: Testing js prompt with selenium", "The result is not as expected");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
