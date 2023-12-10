package stepDefinitions.UI;

import io.cucumber.java.en.When;
import pages.ExpensesPage;
import pages.PreapprovalDetailsPage;

import java.util.Random;

public class ExpensesStepDef {

    @When("the user fill out all required fields on Expenses Page")
    public void the_user_fill_out_all_required_fields_on_expenses_page() {
        new ExpensesPage().getPayment().sendKeys(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
        new PreapprovalDetailsPage().getNextButton().click();


    }
}