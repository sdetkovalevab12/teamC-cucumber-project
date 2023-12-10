package stepDefinitions.UI;

import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import pages.PreapprovalDetailsPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.security.Key;
import java.util.Random;

public class PreapprovalDetailsStepDef {
    @When("the user fill out all required fields on Preapproval Details Page")
    public void the_user_fill_out_all_required_fields_on_preapproval_details_page() {
//        PreapprovalDetailsPage preapprovalDetailsPage= new PreapprovalDetailsPage();
//        if(!preapprovalDetailsPage.getNoForRealtor().isSelected()){
//            preapprovalDetailsPage.getNoForRealtor().click();
//        }
//        preapprovalDetailsPage.getEstimatedPrice().sendKeys(String.valueOf
//                (new Random().nextInt(Integer.MAX_VALUE)), Keys.TAB);
//        SeleniumUtils.waitFor(2);
//        Alert alert = Driver.getDriver().switchTo().alert();
//        alert.accept();
//        //SeleniumUtils.waitForClickablility( preapprovalDetailsPage.getDownpayment(), 5);
//        SeleniumUtils.waitFor(2);
//        preapprovalDetailsPage.getDownpayment().sendKeys(String.valueOf
//                (new Random().nextInt(Integer.MAX_VALUE)));
//        preapprovalDetailsPage.getNextButton().click();


        PreapprovalDetailsPage preapprovalDetailsPage= new PreapprovalDetailsPage();
        if(!preapprovalDetailsPage.getNoForRealtor().isSelected()){
            preapprovalDetailsPage.getNoForRealtor().click();
        }
     //   SeleniumUtils.waitFor(2);
        preapprovalDetailsPage.getEstimatedPrice().sendKeys(String.valueOf
                (new Random().nextInt(Integer.MAX_VALUE)));
     //   SeleniumUtils.waitFor(2);
        preapprovalDetailsPage.getDownpayment().sendKeys("10");
//        SeleniumUtils.waitFor(1);
        preapprovalDetailsPage.getNextButton().click();
    }

}