package com.automation.project.selenium.page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerificationPage {
    WebDriver driver;
    WebDriverWait wait;

    public VerificationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(frame));
    }

    @FindBy(css="iframe[src*='facebook']")
    WebElement frame;

    @FindBy(css = ".uiHeaderTitle")
    WebElement confirmText;

    public boolean verifyConfirmationText() {
        driver.switchTo().frame(frame);
        return confirmText.isDisplayed();
    }
}
