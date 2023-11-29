@smoke @story1
Feature: Sing Up as a new user
  As a potential customer,
  I want to sign up for an account on the bank mortgage application
  so that I can start the process of applying for a mortgage.

  Background:
    Given The user clicks on the sign up link

  Scenario:The Sign Up button should be non-functional until all required input fields
  are filled out correctly.
    When the user enters invalid data in the required fields
    Then the Sign Up button should be disabled
    When the user enters valid data in the required fields
    Then the Sign Up button should be enabled

  Scenario: Clicking the Sign Up button
    When the user enters valid data in the required fields
    And the user click the Sign Up button
    Then "Registration Successful" message should be displayed
    And the user is redirected to the Sign In Page

  Scenario: Sing Up with an existing email
    When the user enters already existing email address
    And the user click the Sign Up button
    Then "This email already used" message should be displayed

  Scenario: "Already have an account? Sign in" link
    And "Already have an account?" message should be displayed
    When the user click "Sign in" link
    Then the user is redirected to the Sign In Page
