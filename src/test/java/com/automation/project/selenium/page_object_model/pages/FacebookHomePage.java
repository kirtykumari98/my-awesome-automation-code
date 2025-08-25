package com.automation.project.selenium.page_object_model.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FacebookHomePage {
    WebDriver driver;
    WebDriverWait wait;

    Logger logger = LogManager.getLogger(FacebookHomePage.class);
    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        if (!isLoaded()) {
            throw new IllegalStateException("we've not logged in to home page!");
        }
    }

    @FindBy(how = How.CSS, using = "a[href*='me'] span")
    WebElement profileName;
    @FindBy(css = "[aria-label='Your profile']")
    WebElement profileImage;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement logOut;

    private boolean isLoaded() {
        wait.until(ExpectedConditions.visibilityOf(profileImage));
        logger.info("the profile image is displayed");
        return profileImage.isDisplayed();
    }

    public String fetchProfileName() {
        profileImage.click();
        logger.info("the text from profile image is "+profileName.getText());
        return profileName.getText();
    }

    public FacebookHomePage clickProfile() {
        profileImage.click();
        logger.info("clicking on the profile image");
        return this;
    }

    public FacebookLoginPage clickLogOut() {
        logOut.click();
        logger.info("the click performed on logout button");
        return new FacebookLoginPage(driver);
    }

    public FacebookLoginPage logOutOfProfile() {
        clickProfile();
        logger.info("Logging out of profile...");
        wait.until(ExpectedConditions.visibilityOf(logOut));
        return clickLogOut();
    }
}
