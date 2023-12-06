@story2 @smoke
Feature: User Sign In

  Background:
   Given the user is on the sign in page

   Scenario: Successful Sign In
     When the user enters a valid email address
     And the user enters a valid password
     Then the user should be redirected to the mortgage account dashboard

  Scenario: Unsuccessful Sign In - Incorrect Credentials
    And the user enters an invalid password
    Then the application should display an error message


  Scenario: Unsuccessful Sign In - Missing Password
    When the user enters a valid email address
    And leaves the password field blank
    Then the application should display an error message

  Scenario: Unsuccessful Sign In - Invalid Email Format
    When the user enters an invalid email address format
    And enters a valid password
    Then the application should display an error message








