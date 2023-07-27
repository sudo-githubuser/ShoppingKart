Feature: Create Account
  Description: Creating account in shopping kart page

  @End2End @SmokeTest @FunctionalTest
Scenario: Create an account
    Given User is on Home Page
    When User clicks on create an account
    And Enter first name "Test"
    And Enter last name "user"
    And Enter email "testuser@test.com"
    And Enter password "Zxcvb@123"
    And Confirm password "Zxcvb@123"
    Then Account created successfully
    And Browser is closed