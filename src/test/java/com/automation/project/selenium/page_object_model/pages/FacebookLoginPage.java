package com.automation.project.selenium.page_object_model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FacebookLoginPage {
    WebDriver driver;
    Logger logger = LogManager.getLogger(FacebookLoginPage.class);
    WebDriverWait wait;
    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("navigated to the Login page");

        if (isNotLoaded()) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    private boolean isNotLoaded() {
        boolean isNotLoaded = true;
        wait.until(ExpectedConditions.visibilityOf(txtEmail1));
        if (txtEmail1.isDisplayed()) {
            isNotLoaded = false;
        }
        return isNotLoaded;
    }


    By password = By.id("pass");
    By login = By.name("login");
    @FindBy(css = "#email")//AND condition
    WebElement txtEmail1;
    @FindBy(css = "[data-testid='open-registration-form-button']")
    WebElement createAccountBtn;

    public FacebookLoginPage typeEmail(String emailValue) {
        txtEmail1.sendKeys(emailValue);
        logger.info("typing email "+emailValue);
        return this;
    }

    public FacebookLoginPage typePassword(String passwordValue) {
        driver.findElement(password).sendKeys(passwordValue.trim());
        logger.info("typing password "+passwordValue);
        return this;
    }

    public FacebookHomePage clickLogin() {
        driver.findElement(login).click();
        logger.info("navigating to the home page");
        return new FacebookHomePage(driver);
    }

    public CreateAccountPage clickCreateAccount() {
        createAccountBtn.click();
        logger.info("clicked on create account button");
        return new CreateAccountPage(driver);
    }

}
