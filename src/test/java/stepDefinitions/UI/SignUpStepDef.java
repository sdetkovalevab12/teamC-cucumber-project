package stepDefinitions.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.SignUpPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class SignUpStepDef {

    @When("the user enters invalid data in the required fields")
    public void the_user_enters_invalid_data_in_the_required_fields() {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        signUpPage.getFirstName().sendKeys(faker.name().firstName()+((int)(Math.random())));
        signUpPage.getLastName().sendKeys(faker.name().lastName()+((int)(Math.random())));
        signUpPage.getEmail().sendKeys(SeleniumUtils.generateRandomSequenceOfChar((int)(Math.random())));
        signUpPage.getPassword().sendKeys(faker.internet().password(1,6).toLowerCase());
    }
    @Then("the Sign Up button should be disabled")
    public void the_sign_up_button_should_be_disabled() {
     // Assert.assertFalse(new SignUpPage().getSignUpButton().isEnabled());
     // Assert.assertFalse(new SignUpPage().getSuccessMsg().isDisplayed());
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getSignUpButton().click();
        Assert.assertTrue(signUpPage.getPageHeader().getText().contains("Sign Up"));

    }
    @When("the user enters valid data in the required fields")
    public void the_user_enters_valid_data_in_the_required_fields() {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        Driver.getDriver().navigate().refresh();
        signUpPage.getFirstName().sendKeys(faker.name().firstName());
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys(faker.internet().emailAddress());
        signUpPage.getPassword().sendKeys(faker.internet().password(8,50,true));
    }
    @Then("the Sign Up button should be enabled")
    public void the_sign_up_button_should_be_enabled() {
        Assert.assertTrue(new SignUpPage().getSignUpButton().isEnabled());
    }

    @When("the user click the Sign Up button")
    public void the_user_click_the_sign_up_button() {
        new SignUpPage().getSignUpButton().click();
    }
    @Then("{string} message should be displayed")
    public void registration_successful_message_should_be_displayed(String msg) {
     //  SeleniumUtils.waitForPresenceOfElementLocated(By.xpath("//*[text()='Registration Successfull']" ),5);
         Assert.assertTrue(new SignUpPage().getMsg(msg).isDisplayed());
    }
    @Then("the user is redirected to the Sign In Page")
    public void the_user_is_redirected_to_the_sign_in_page() {
        Assert.assertTrue(new SignUpPage().getPageHeader().getText().contains("Welcome Back!"));
    }

    @When("the user enters already existing email address")
    public void the_user_enters_already_existing_email_address() {
        SignUpPage signUpPage =new SignUpPage();
//        the_user_enters_valid_data_in_the_required_fields();
//        signUpPage.getEmail().sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE), ConfigReader.getProperty("email"));
        Faker faker = new Faker();
        signUpPage.getFirstName().sendKeys(faker.name().firstName());
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys( ConfigReader.getProperty("email"));
        signUpPage.getPassword().sendKeys(faker.internet().password(8,50,true));
    }

    @When("the user click {string} link")
    public void the_user_click_link(String string) {
      Driver.getDriver().findElement(By.linkText(string)).click();
    }


}
