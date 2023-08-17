Feature: Create Account
  Description: Creating account in shopping kart page

  Rule: Users can create a new account in shopping kart
    Background:
      Given User is on Home Page
      When User clicks on create an account


  @End2End @SmokeTest @FunctionalTest
Scenario: Create an account with valid and unique email ID
    When Enter first name "Test28"
    * Enter last name "user28"
    * Enter email "useta@tie.cm"
    * Enter password "Zxcvb@123"
    * Confirm password "Zxcvb@123"
    * Submit
    Then Account created successfully
    And Browser is closed

Scenario: Create an account with duplicate email ID
  When Enter first name "Test28"
  * Enter last name "user28"
  * Enter email "useta@tie.cm"
  * Enter password "Zxcvb@123"
  * Confirm password "Zxcvb@123"
  * Submit
  Then Account not created successfully
  And Browser is closed
