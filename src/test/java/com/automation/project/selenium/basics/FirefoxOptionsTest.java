package com.automation.project.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirefoxOptionsTest {
    private WebDriver driver;
    private FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Test(description = "normal page load strategy", groups = "strategy")
    public void normalStrategy() {
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    }

    @Test(groups = "strategy")
    public void eagerStrategy() {
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
    }

    @Test(groups = "strategy")
    public void noneStrategy() {
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
    }

    @Test(description = "setting up the page load strategy", dependsOnGroups = "strategy")
    public void startDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver(firefoxOptions);
    }

    @Test(description = "testing the page load strategy with different options", dependsOnMethods = {"normalStrategy", "startDriver"})
    public void testNormalStrategy() {

        driver.get("https://codepen.io/kjoypayton/pen/EygxLv");
        assertTrue(driver.findElement(By.id("html-toggle")).isDisplayed(), "The element is not displayed");
    }

    @Test(description = "testing the page load strategy with different options", dependsOnMethods = {"eagerStrategy", "startDriver"})
    public void testEagerStrategy() {

        driver.get("https://codepen.io/kjoypayton/pen/EygxLv");
        assertTrue(driver.findElement(By.id("html-toggle")).isDisplayed(), "The element is not displayed");
    }

    @Test
    public void testNoneStrategy() {
        driver.get("https://codepen.io/kjoypayton/pen/EygxLv");
        assertTrue(driver.findElement(By.id("html-toggle")).isDisplayed(), "The element is not displayed");
    }


}
