#Feature:Adding expenses information
#  As a potential homebuyer,
#  I want to use the Expenses page of my bank's mortgage application to provide information about
#  my current living situation and expenses
#  so that I can move forward with the mortgage application process
#
#  Background:
#    Given the user logs in into account
#    And the user click "Mortgage Application" link
#    And the user select "Expenses" from the left menu
#
#  @story6
#    Scenario: Compleating "Do you currently rent or own?" field
#    And "Do you currently rent or own?" field should have 2 checkboxes
#    And checks boxes values shoud be "Rent" and "Own"
#    And the user should be able to select only one checkbox
#
#    Scenario: Rent checkbox
#    When the user selects "Rent"
#    Then "Monthly Rental Payment" field should be required and must be a positive number
#    When entered input is a numeric value less than 0
#    Then "Please enter a value greater than or equal to 0. " message should be displayed
#    When entered input is a non-numeric value
#    Then "Please enter a valid number." message should be displayed
#
#    Scenario: Own checkbox
#    When the user selects "Own"
#    Then "Monthly Mortgage Payment" field should be required and must be a positive number
#    When entered input is a numeric value less than 0
#    Then "Please enter a value greater than or equal to 0. " message should be displayed
#    When entered input is a non-numeric value
#    Then "Please enter a valid number." message should be displayed
#
#
#  Scenario Outline: Previous and Next buttons functionality
#   When the user select "<button>"
#   Then the user navigates to "<url>"
#  Examples:
#    | button  | url                   |
#    | button  | url                   |
#    | button  | url                   |
#
#    Scenario: Moving forward with partial compleation og the page
#      When the following option is empty
#        | "Monthly Rental Payment"    |
#        | "Monthly Mortgage Payment"  |
#      And the user select "Next" button
#      Then the user should not be able to proceed to the next page
#
#     Scenario: Moving forward
#       When user should be able to move forward to the next page of the application only after all required fields have been completed