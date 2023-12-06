@creditReport
Feature: Order Credit Report through Preapproval Inquiry Page

  As a user applying for a mortgage loan,
  I want to be able to order a credit report through the preapproval inquiry page,
  so that the bank can verify my eligibility for the loan.

  Background:
    Given the user is on the Preapproval Inquiry page

  Scenario Outline: User chooses to order a credit report
    When the user selects Yes on the credit report order section
    Then the user should be taken to a secure third-party website to order their credit report "<linkName>"
    And the url to the third-party website "<url2>"
    Then verify the "<status>"

    Examples:

      | linkName      | url2                                                          | status |
      | credit report | http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php | passed |

  Scenario: User chooses not to order a credit report
    When the user selects No on the credit report order section
    And the user submits the application
    Then the user should not be taken to the third-party website
    And no credit report should be ordered
