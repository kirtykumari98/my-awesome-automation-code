package com.automation.project.selenium.advanced.selenium_4_features;

import com.automation.project.selenium.basics.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelativeLocatorsExample extends SetupDriver {

    By emailText = RelativeLocator.with(By.tagName("input")).above(By.id("pass"));
    By passwordText = RelativeLocator.with(By.tagName("input")).below(By.className("_6lux"));
    By lastNameText = RelativeLocator.with(By.tagName("input")).toRightOf(By.name("firstname"));
    By createNewAccountButton = RelativeLocator.with(By.xpath("//div[@class='_6ltg']/a")).below(By.name("login"));

    @BeforeMethod
    public void openFacebookLogin() {
        driver.navigate().to("https://facebook.com");
    }

    @Test
    public void testAboveLocator() {
        driver.findElement(emailText).sendKeys("username field");
    }

    @Test
    public void testBelowLocator() {
        driver.findElement(passwordText).sendKeys("password");
    }

    @Test
    public void testLeftOfLocator() {
        driver.findElement(createNewAccountButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(lastNameText));
        driver.findElement(lastNameText).sendKeys("lastname");
    }

    @Test
    public void testNewTabWithSelenium4()
    {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://google.com");
    }

    @Test
    public void testNewWindowWithSelenium4() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://google.com");
    }
}
