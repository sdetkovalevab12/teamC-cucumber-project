package stepDefinitions.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import pages.PreapprovalDetailsPage;
import stepDefinitions.SharedData;
import utils.Driver;
import utils.SeleniumUtils;

import java.security.Key;
import java.util.Random;

public class PreapprovalDetailsStepDef {

    SharedData sharedData;

    public PreapprovalDetailsStepDef(SharedData sharedData){this.sharedData=sharedData;}
    @When("the user fill out all required fields on Preapproval Details Page")
    public void the_user_fill_out_all_required_fields_on_preapproval_details_page() {
        Faker faker = new Faker();
        PreapprovalDetailsPage preapprovalDetailsPage= new PreapprovalDetailsPage();
        preapprovalDetailsPage.clickCheckBoxForRealtor("Yes");

        String realtorName= faker.name().fullName();
        preapprovalDetailsPage.getRealtorName().sendKeys(realtorName);
        sharedData.setRealtorName(realtorName);
        Integer estimatePrice=new Random().nextInt(Integer.MAX_VALUE);
        preapprovalDetailsPage.getEstimatedPrice().sendKeys(String.valueOf(estimatePrice));
        sharedData.setEstimatePurchasePrice(estimatePrice);
        Integer downpayment =(int)(estimatePrice* 0.06);
        preapprovalDetailsPage.getDownpayment().sendKeys(String.valueOf(downpayment));
        sharedData.setDownpayment(downpayment);
        preapprovalDetailsPage.getNextButton().click();
    }

}
