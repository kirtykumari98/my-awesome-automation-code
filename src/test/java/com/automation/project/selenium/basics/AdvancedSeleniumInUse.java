package com.automation.project.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdvancedSeleniumInUse extends SetupDriver{

    public static final String PRODUCTS_MENU="product-menu-toggle";

    @Test
    public void testMouseActions() {
        driver.get("https://www.browserstack.com");
        WebElement productsMenu = driver.findElement(By.id(PRODUCTS_MENU));
        WebElement liveItem= driver.findElement(By.cssSelector("[href='/live']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(productsMenu)
                .moveByOffset(0,200)
                .click()
                .build()
                .perform();
    }


    @Test
    public void dragAndDrop() { //test logic
        driver.get("https://www.youidraw.com/apps/painter/");//test data
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.id("shape"))) //locators
                .moveToElement(driver.findElement(By.id("catch")))
                .dragAndDropBy(driver.findElement(By.id("catch")), 234, 234)
                .contextClick().moveToElement(driver.findElement(By.xpath("//a[text()='Delete']"))).click()
                       .build().perform();
    }
    @Test
    public void testKeyBoardAction() {
        driver.get("https://www.google.com");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(driver.findElement(By.name("q")), "testing sendkeys with shift")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}
