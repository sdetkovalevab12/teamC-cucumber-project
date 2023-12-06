package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderCreditReport;

public class OrderCreditReportStepDef {
    @Given("the user is on the Preapproval Inquiry page")
    public void the_user_is_on_the_preapproval_inquiry_page() {

    }
    @When("the user selects Yes on the credit report order section")
    public void the_user_selects_yes_on_the_credit_report_order_section() {
        new OrderCreditReport().getCheckBoxYes().click();

    }
    @Then("the user should be taken to a secure third-party website to order their credit report {string}")
    public void the_user_should_be_taken_to_a_secure_third_party_website_to_order_their_credit_report(String linkName) {

    }
    @Then("the url to the third-party website {string}")
    public void the_url_to_the_third_party_website(String url2 ) {

    }

    @Then("verify the {string}")
    public void verify_the(String status) {

    }
    @When("the user selects No on the credit report order section")
    public void the_user_selects_no_on_the_credit_report_order_section() {

    }
    @When("the user submits the application")
    public void the_user_submits_the_application() {

    }
    @Then("the user should not be taken to the third-party website")
    public void the_user_should_not_be_taken_to_the_third_party_website() {

    }
    @Then("no credit report should be ordered")
    public void no_credit_report_should_be_ordered() {

    }

}
