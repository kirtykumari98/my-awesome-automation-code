package com.automation.project.bdd_in_action.stepdefinition;

import com.automation.project.bdd_in_action.base.BaseTest;
import com.automation.project.selenium.page_object_model.pages.FacebookLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.automation.project.selenium.page_object_model.pages.CreateAccountPage;

public class FacebookAccountCreationSteps extends BaseTest {

    FacebookLoginPage facebookLoginPage;
    CreateAccountPage createAccountPage;

    @When("user clicks on create new account button on facebook login page")
    public void user_clicks_on_create_new_account_button_on_facebook_login_page() {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.clickCreateAccount();

    }

    @Then("sign up page should be opened")
    public void sign_up_page_should_be_opened() {
        createAccountPage = new CreateAccountPage(driver);
    }

}
