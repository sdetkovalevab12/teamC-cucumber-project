Feature: Dashboard functionalities
  As a user who has applied for a mortgage with a bank,
  I want to be able to access the dashboard page of the bank's mortgage application system
  So that I can view my account information, apply for a new mortgage,
  and view a list of my previous mortgage applications.

  Background:
    Given the user logs in into account

  Scenario: Verifying Dashboard
  Then the bank's logo should be displayed
  And the dashboard page should include following links:
  |Mortgage Application |
  |Application List     |

  Scenario Outline:Navigating to the Application List
  When the user click "<link>"
  Then  the user should be redirected to "<url>"
 Examples:
 |link                 |url                                                                |
 |Mortgage Application | http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php     |
 |Application List     | http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php |
  @story3
    Scenario: Loging out
    Then The user's account information should be displayed in the top right corner of the page
    When the user click on the user name
    Then dropdown menu should display a "Logout" link
    When the user click "LOGOUT" link
    Then the user is redirected to the Sign In Page
