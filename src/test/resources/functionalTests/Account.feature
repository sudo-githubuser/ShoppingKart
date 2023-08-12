Feature: Create Account
  Description: Creating account in shopping kart page

  @End2End @SmokeTest @FunctionalTest
Scenario: Create an account
    Given User is on Home Page
    When User clicks on create an account
    And Enter first name "Test7"
    And Enter last name "user7"
    And Enter email "coffuse9@gqe.com"
    And Enter password "Zxcvb@123"
    And Confirm password "Zxcvb@123"
    And Submit
    Then Account created successfully
    And Browser is closed