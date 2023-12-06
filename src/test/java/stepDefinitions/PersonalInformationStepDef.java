package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.PersonalInformationPage;
import pages.PreapprovalDetailsPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Random;

public class PersonalInformationStepDef {

    @When("the user fill out all required fields on Personal Information Page")
    public void the_user_fill_out_all_required_fields_on_personal_information_page() {
        PersonalInformationPage personalInformationPage= new PersonalInformationPage();
        Faker faker=new Faker();
        personalInformationPage.getFirstName().sendKeys(faker.name().firstName(), Keys.TAB,  Keys.TAB,
                faker.name().lastName(),Keys.TAB,  Keys.TAB, faker.internet().emailAddress());
       // SeleniumUtils.waitForClickablility( personalInformationPage.getSsn(), 5);
        SeleniumUtils.waitFor(1);
        personalInformationPage.getSsn().sendKeys( faker.idNumber().valid());

//        Select select= new Select(personalInformationPage.getMaritalStatus());
//        SeleniumUtils.waitForVisibility(personalInformationPage.getMaritalStatus(),5);
//        select.selectByIndex(new Random().nextInt(3));
//        personalInformationPage.getMaritalStatus().click();
//        personalInformationPage.getOption().click();
        SeleniumUtils.waitFor(1);
        personalInformationPage.getMaritalStatus1().click();
        //  personalInformationPage.getMarried().click();
        personalInformationPage.getSearchMarried().sendKeys("Married", Keys.ENTER);
        personalInformationPage.getCellPhone().sendKeys(faker.phoneNumber().cellPhone());


        personalInformationPage.getCellPhone().sendKeys(faker.phoneNumber().cellPhone());
        new PreapprovalDetailsPage().getNextButton().click();
    }



}
