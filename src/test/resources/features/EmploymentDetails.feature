Feature:Employment and income details
 As a user applying for a mortgage loan,
 I want to provide my employment and income details to the bank,
 so that they can evaluate my eligibility for a loan.

@story7
Scenario:  Pre steps
  When the user logs in into account
   And the user click "Mortgage Application" link
   And the user fill out all required fields on Preapproval Details Page
   And the user fill out all required fields on Personal Information Page
   And the user fill out all required fields on Expenses Page
   Then the user click "Employment and Income" link



#
# Acceptance Criteria:
#
#Borrower Employment Information:
#oIt should contain fields for EMPLOYER NAME, POSITION, CITY, and a
#dropdown box for STATE, and a date picker for START DATE and END
#DATE.
#oEMPLOYER NAME should be a required input field.
#oSTATE should be as dropdown list with all 50 US states and their two-
#letter abbreviations.
#oThe checkbox labeled "This is my current job" should be unchecked by
#default.
#oThe section should have a "Clear" option that displays a warning pop-
#up about clearing the information.
#oThe "Clear" option should only clear the information in that section, not
#any other sections.
#oThe user should be able to enter only valid information in each field.
#oThe "Add another employer" button should let the user add a new
#section for another employer's information.
#oEach new section should contain the same fields as the first section.
#oThe section should have a "Clear" option that displays a warning pop-
#up about clearing the information.
#oThe "Clear" option should only clear the information in that section, not
#any other sections.
#oThe user should be able to remove a section using the "Remove"
#option.
#Borrower Gross Monthly Employment Income section:
#oThe section should contain fields for GROSS MONTHLY INCOME,
#MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS,
#MONTHLY DIVIDENDS/INTEREST, and Borrower Total Monthly Income.
#oAll fields in this section should only accept numeric input (digits and
#decimal points) with a maximum of two decimal places. The maximum
#character limit for the fields should be 12 characters.
#oGROSS MONTHLY INCOME should be a required input field.
#oThe "Borrower Total Monthly Income" field should be automatically
#calculated based on the other fields.
#Additional Gross Monthly Income section:
#oThe section should contain three sets of INCOME SOURCE dropdowns
#and Amount fields.
#oINCOME SOURCE dropdown should have Alimony/Child Support, Social
#Security/Disability Income, Unemployment Benefits, Interest and
#Dividends, VA Compensation, Royalty Payments and Other Types of
#Income options.
#Previous and Next Buttons:
#oThe user should be able to navigate to other sections using the
#"Previous" and "Next" buttons.
#oThe "Previous" button should take the user to the previous section.
#oThe "Next" button should take the user to the next section only if all
#required fields are filled in.
#oIf a required field is not filled in, the "Next" button should not navigate
#to the next section and display an error message indicating which field
#needs to be filled in.