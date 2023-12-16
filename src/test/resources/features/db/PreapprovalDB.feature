@DB
Feature: Preapproval details
  As a user of Duobank Mortgage Application,
  I want my Preapproval Details page data to be stored in the database,
  so that I can access it later and the bank can process my mortgage application

@smoke @db_only
  Scenario:verify column names for songs table
    When I retrieve the column names from the "tbl_mortagage" table
    Then it should have the following
      | id                   |
      | realtor_status       |
      | realtor_info         |
      | loan_officer_status  |
      | purpose_loan         |
      | est_purchase_price   |
      | down_payment         |
      | down_payment_percent |
      | total_loan_amount    |
      | src_down_payment     |
      | add_fund_available   |


  Scenario Outline: Realtor status field values
    When the user logs in into account
    And the user click "Mortgage Application" link
    And the user set the realtor status field to "<choice>"
    And the user submit the whole application
    Then the corresponding column in the "tbl_mortagage" table should be set to <number>
    And the user is cleaned up from the database
    Examples:
    |choice | number |
    |Yes    | 1      |
    |No     | 2      |




   @db_only
  Scenario: Unique identifier for each mortgage application
  Given each application should have a unique identifier in the "tbl_mortagage" table

@try
  Scenario:Verify data mapping of "Preapproval Details" page
    When the user logs in into account
    And the user click "Mortgage Application" link
    Then the user fill out all required fields on Preapproval Details Page
    And the user submit the whole application
    Then the data should be mapped correctly in the "tbl_mortagage" table
    And the user is cleaned up from the database




#
#  Scenario Outline: Check data types of the columns in the "tbl_mortagage" table
#    When the user logs in into account
#    And the user click "Mortgage Application" link
#    When the user insert "<input_data>" into the "<field>"
#    Then the data should be stored as a "<data_type>" in "<column>"
#
#    Examples:
#
#      | input_data | field        | data_type | column             |
#      | Yes        | realtor      | 1         | realtor_status     |
#      | "John Doe" | realtor name | Sting     | realtor_info       |
#      | 300000     | estimate     | Integer   | est_purchase_price |
#      | 3000       | downpayment  | Integer   | down_payment       |



