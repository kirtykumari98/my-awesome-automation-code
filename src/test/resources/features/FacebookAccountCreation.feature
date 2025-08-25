Feature: As a user, I want to create a facebook account
  So that I can login to my account

  Background: Open facebook login page
    Given users opens to "https://www.facebook.com"

    Scenario: Opening sign up form
      Given facebook page is open
      When user clicks on create new account button on facebook login page
      Then sign up page should be opened

      Scenario: Create facebook account
         When user types first name ""
        And user types last name ""
        And user clicks on sign up button
        Then verification page should be opened


