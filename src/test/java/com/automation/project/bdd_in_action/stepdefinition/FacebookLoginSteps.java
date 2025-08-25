package com.automation.project.bdd_in_action.stepdefinition;

import com.automation.project.bdd_in_action.base.BaseTest;
import com.automation.project.selenium.page_object_model.pages.FacebookHomePage;
import com.automation.project.selenium.page_object_model.pages.FacebookLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginSteps extends BaseTest {

    FacebookLoginPage facebookLoginPage;
    FacebookHomePage facebookHomePage;
    @Given("I/user/users navigate(s)/opens to {string}")
    public void iNavigateTo(String url) {
       driver.navigate().to(url);
    }

    @Given("facebook page is open")
    public void facebookPageIsOpen() {
        facebookLoginPage= new FacebookLoginPage(driver);
    }

    @When("I enter {string} and {string} in email and password fields")
    public void iEnterAndInEmailAndPasswordFields(String username, String password) {
        facebookLoginPage.typeEmail(username);
        facebookLoginPage.typePassword(password);
    }

    @Then("I want to see my profile page")
    public void iWantToSeeMyProfilePage() {
        facebookLoginPage.clickLogin();
    }

    @And("I sign out of my profile page")
    public void iSignOutOfMyProfilePage() {
        facebookHomePage= new FacebookHomePage(driver);
        facebookHomePage.logOutOfProfile();
    }

}
