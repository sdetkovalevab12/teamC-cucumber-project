package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.Driver;

public class LogInStepDef {

    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() {
        new LoginPage();

    }
    @When("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() {
        new LoginPage().getEmailInput().sendKeys("tester.in.test.b12@gmail.com");

    }
    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        new LoginPage().getPasswordInput().sendKeys("Test123!");

    }
    @Then("the user should be redirected to the mortgage account dashboard")
    public void the_user_should_be_redirected_to_the_mortgage_account_dashboard() {
        new LoginPage().getSignIn().click();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());

    }

    @Given("the user enters an invalid password")
    public void the_user_enters_an_invalid_password()  {
        new LoginPage().getEmailInput().sendKeys("tester.in.test.b12@gmail.com" );
        new LoginPage().getPasswordInput().sendKeys("Test1234");
        new LoginPage().getSignIn().click();

    }

    @Then("the application should display an error message")
    public void the_application_should_display_an_error_message() {
    LoginPage loginPage= new LoginPage();
    Assert.assertTrue(loginPage.getErrorText().isDisplayed());
    }
    @When("leaves the password field blank")
    public void leaves_the_password_field_blank() {

        new LoginPage().getEmailInput().sendKeys("tester.in.test.b12@gmail.com" );
        new LoginPage().getSignIn().click();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.getErrorText().isDisplayed());


    }
    @When("the user enters an invalid email address format")
    public void the_user_enters_an_invalid_email_address_format() {

    new LoginPage().getEmailInput().sendKeys("tester.in.test.b12.com");

    }
    @When("enters a valid password")
    public void enters_a_valid_password() {

        new LoginPage().getPasswordInput().sendKeys("Test123!");
        new LoginPage().getSignIn().click();
        Assert.assertTrue(new LoginPage().getErrorText().isDisplayed());

    }

}