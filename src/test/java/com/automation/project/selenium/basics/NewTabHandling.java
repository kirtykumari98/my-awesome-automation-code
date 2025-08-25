package com.automation.project.selenium.basics;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;


public class NewTabHandling extends SetupDriver{

    @Test
    public void openNewTabWithoutWaits() throws AWTException {
        driver.navigate().to("https://www.google.com");
        String currentHandle = driver.getWindowHandle();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_CONTROL);
        rob.keyPress(KeyEvent.VK_T);
        rob.keyRelease(KeyEvent.VK_CONTROL);
        rob.keyRelease(KeyEvent.VK_T);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        System.out.println("The window handles are " + handles);
        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.get("https://www.facebook.com");
        driver.close();
        driver.switchTo().window(currentHandle);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
