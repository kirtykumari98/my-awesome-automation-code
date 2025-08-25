package com.automation.project.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesTested extends SetupDriver {


    @Test
    public void testPageWithMultipleFrames() {
        driver.get("https://codepen.io/kjoypayton/pen/EygxLv");
        System.out.println("the title of the previous frame: " + driver.findElement(By.cssSelector("#html-editor-title")).getText());
        driver.switchTo().frame("CodePen");
        driver.findElement(By.cssSelector(".thumbnail")).isDisplayed();
        WebElement frameInternal = driver.findElement(By.cssSelector("[src='https://www.foxnews.com']"));
        driver.switchTo().frame(frameInternal);
        driver.findElement(By.cssSelector("#welcome-ovr")).isDisplayed();
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("#welcome-ovr")).isDisplayed();
        driver.switchTo().defaultContent();

        System.out.println("the title of the previous frame: " + driver.findElement(By.cssSelector("#html-editor-title")).getText());

    }

    @Test
    public void navigateToFrame()
    {
        driver.get("https://codepen.io/kjoypayton/pen/EygxLv");
        WebElement huffingtonPostFrame=driver.findElement(By.cssSelector("[src*='huffing']"));
        driver.switchTo().frame(0);
        System.out.println(driver.getPageSource());
    }


}
