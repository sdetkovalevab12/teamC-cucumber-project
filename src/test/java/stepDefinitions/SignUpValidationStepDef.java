package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.SignInPage;
import pages.SignUpPage;
import utils.ConfigReader;

public class SignUpValidationStepDef {

    @Given("The user clicks on the sign up link")
    public void the_user_clicks_on_the_sign_up_link() {
        new SignInPage().getSignUpButton().click();
    }

    @Then("The user sees that {string} field has clear label, displayed and required")
    public void the_user_sees_that_field_is_displayed_and_required(String string) {
        SignUpPage signUpPage = new SignUpPage();
        WebElement field= signUpPage.getField(string);
        Assert.assertTrue(field.isDisplayed());
        Assert.assertTrue(string.equals(field.getAttribute("placeholder")));
        Assert.assertEquals("true", field.getAttribute("required"));
    }

    @Then("{string} field accepts only letters and spaces")
    public void field_accepts_only_letters_and_spaces(String string) {
    SignUpPage signUpPage =new SignUpPage();
    WebElement field = signUpPage.getField(string);
    Assert.assertEquals("Please enter only letters and spaces", field.getAttribute("title"));
    Assert.assertEquals("^[A-Za-z\\s]*$", field.getAttribute("pattern"));
    }
    @Then("{string} field has maximum length of {int} characters")
    public void field_has_maximum_length_of_characters(String string, Integer maxLength) {
        SignUpPage signUpPage =new SignUpPage();
        WebElement field = signUpPage.getField(string);
        Assert.assertEquals(maxLength, Integer.valueOf(field.getAttribute("maxlength")));
    }

    @Then("{string} field in a valid email format")
    public void field_in_a_valid_email_format(String string) {
        SignUpPage signUpPage =new SignUpPage();
        WebElement field = signUpPage.getField(string);
        Assert.assertEquals("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", field.getAttribute("pattern"));
        Assert.assertEquals("Please enter a valid email address", field.getAttribute("title"));
    }

    @Then("Password is at least 8 characters long an contain at least one uppercase letter, one lowercase letter, and one number")
    public void is_at_least_characters_long_an_contain_at_least_one_uppercase_letter_one_lowercase_letter_and_one_number() {
        SignUpPage signUpPage =new SignUpPage();
        Assert.assertEquals("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", signUpPage.getPassword().getAttribute("pattern"));
        Assert.assertEquals("Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters",
                signUpPage.getPassword().getAttribute("title"));
    }

    @Then("{string} can not be a duplicate of an existing email address in the database")
    public void can_not_be_a_duplicate_of_an_existing_email_address_in_the_database(String string) {
        SignUpPage signUpPage =new SignUpPage();
        signUpPage.getEmail().sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);
        Assert.assertTrue(signUpPage.getEmailError().isDisplayed());
    }
}
