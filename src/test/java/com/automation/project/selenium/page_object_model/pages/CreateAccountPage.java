package com.automation.project.selenium.page_object_model.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class CreateAccountPage {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker = new Faker(new Locale("en_IN"));

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        if (!txtFirstName.isDisplayed()) {
            throw new IllegalStateException("we are  not on sign up page");
        }
    }

    @FindBy(name = "firstname")
    WebElement txtFirstName;
    @FindBy(name = "lastname")
    WebElement txtLastName;
    @FindBy(name = "reg_email__")
    WebElement txtMobileEmail;
    @FindBy(id = "password_step_input")
    WebElement txtPassword;
    @FindBy(id = "day")
    WebElement birthdayDdwn;
    @FindBy(id = "month")
    WebElement birthMonthDdwn;
    @FindBy(id = "year")
    WebElement birthYearDdwn;
    @FindBy(name = "sex")
    WebElement genderRadio;
    @FindBy(name = "websubmit")
    WebElement signUpBtn;


    public CreateAccountPage typeFirstName() {
        txtFirstName.sendKeys(faker.name().firstName());
        return this;
    }

    public CreateAccountPage typeLastName() {
        txtLastName.sendKeys(faker.name().lastName());
        return this;
    }

    public CreateAccountPage typeEmail() {
        txtMobileEmail.sendKeys("7894561236");
        return this;
    }

    public CreateAccountPage typePassword() {
        txtPassword.sendKeys("Facebook123$");
        return this;
    }

    public CreateAccountPage selectDropdwon() {
        Select select = new Select(birthdayDdwn);
        select.selectByVisibleText("20");
        return this;
    }

    public CreateAccountPage selectMonth() {
        Select select = new Select(birthMonthDdwn);
        select.selectByVisibleText("May");
        return this;
    }

    public CreateAccountPage selectYear() {
        Select select = new Select(birthYearDdwn);
        select.selectByVisibleText("1998");
        return this;
    }

    public CreateAccountPage selectGender() {
        genderRadio.click();
        return this;
    }

    public CreateAccountPage clickSignUp() {
        signUpBtn.click();
        return this;
    }

    public VerificationPage createAccountValid() {
        typeFirstName();
        typeLastName();
        typeEmail();
        typePassword();
        selectDropdwon();
        selectMonth();
        selectYear();
        selectGender();
        clickSignUp();
        return new VerificationPage(driver);
    }
}
