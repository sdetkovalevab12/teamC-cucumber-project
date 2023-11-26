@smoke @story1
Feature: Validation of Sing Up input fields

  Background:
  Given The user clicks on the sign up link

  Scenario: Validating First Name Field
    Then The user sees that "First name" field has clear label, displayed and required
    And "First name" field accepts only letters and spaces
    And "First name" field has maximum length of 50 characters

  Scenario: Validating Last Name Field
    Then The user sees that "Last name" field has clear label, displayed and required
    And "Last name" field accepts only letters and spaces
    And "Last name" field has maximum length of 50 characters

  Scenario: Validating Email Address Field
    Then The user sees that "Email address" field has clear label, displayed and required
    And "Email address" field in a valid email format
    And "Email address" field has maximum length of 255 characters

  Scenario: Validating Password Field
    Then The user sees that "Password" field has clear label, displayed and required
    And Password is at least 8 characters long an contain at least one uppercase letter, one lowercase letter, and one number
    And "Password" field has maximum length of 50 characters

