Feature: As a facebook user, I want to login to my facebook account

  Background: Open facebook page
    Given users opens to "https://www.facebook.com"

  @loginWithMultipleIds
  Scenario Outline: Verify the facebook login
    Given facebook page is open
    When I enter "<username>" and "<password>" in email and password fields
    Then I want to see my profile page
    And I sign out of my profile page
    Examples:
      | username                  | password          |
      | sharada.doddi09@gmail.com | Facebook123$      |
      | nidhi.r@gmail.com         | nidhi.r@gmail.com |

  Scenario: Verify that I cannot login with invalid password
    Given facebook page is open
    When I enter "nidhi.r@gmail.com" and "afdsg" in email and password fields
    Then I should be shown an error

    @singleScenario
  Scenario Outline: Login to facebook page
    Given facebook page is open
    When I enter "<username>" and "<password>" in email and password fields
    Then I want to see my profile page
    Examples:
      | username      | password |
      | 122@gmail.com | 122      |
      | 242@gmail.com | 242      |
