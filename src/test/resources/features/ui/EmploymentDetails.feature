@story7
Feature:Employment and income details
 As a user applying for a mortgage loan,
 I want to provide my employment and income details to the bank,
 so that they can evaluate my eligibility for a loan.


Background:
   When the user logs in into account
   And the user click "Mortgage Application" link
   And the user fill out all required fields on Preapproval Details Page
   And the user fill out all required fields on Personal Information Page
   And the user fill out all required fields on Expenses Page


Scenario: Borrower Employment Information
 When the user is redirected to the "Employment and Income"
 Then the Employer 1 should contain the following fileds
  | Employer Name |
  | Position      |
  | City          |
  | State         |
  | Start Date    |
 # |End Date       |

 Scenario: Fields
 When the user click "Next"
 Then "This field is required." message should be displayed

 Scenario: Validating fields
 Then dropdown should have 50 states
  And dropdown options should have two-letter abbreviations
  And checkbox labeled 'This is my current job' should be unchecked


Scenario: "Clear" option for Emploee
  When the user fill out all required fields on Emploement Page
  And the user click Clear
  Then "This action will clear the form, would you like to continue?" message should be displayed
 When the user click Yes!
 Then information from section is removed



Scenario: "Add another employer" button
 When the user click "Add another employer"
 Then a new section for another employer's information is displayed
 And the "Employer2" should contain the following fileds
| Employer Name |
| Position      |
| City          |
| State         |
| Start Date    |
|End Date       |

 Scenario: "Remove" option for
 When the user click "Add another employer"
  Then a new section for another employer's information is displayed
 When the user click "Remove"
 Then the section is removed


 Scenario Outline: Navigation  buttons
  When the user fill out all required fields on Emploement Page
  And  the user click "<button>"
  Then the user is redirected to the "<section>"
 Examples:
  | button   | section       |
  | Next     | Expenses      |
  | Previous | Credit Report |

