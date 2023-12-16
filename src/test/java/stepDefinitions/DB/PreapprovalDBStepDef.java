package stepDefinitions.DB;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.*;
import stepDefinitions.SharedData;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.*;

public class PreapprovalDBStepDef {
    List<String> columnNames;
    SharedData sharedData;

    public PreapprovalDBStepDef(SharedData sharedData){this.sharedData=sharedData;}

    @When("I retrieve the column names from the {string} table")
    public void i_retrieve_the_column_names_from_the_table(String string) {
        columnNames = DBUtils.getColumnNames("select * from "+string+" limit 1;");

    }
    @Then("it should have the following")
    public void it_should_have_the_following(List<String> expectedColumns) {
              List<String> preapprovalColumns= new ArrayList<String>();
       for (int i=0; i<11; i++){
           preapprovalColumns.add(columnNames.get(i));
       }
       Assert.assertEquals( expectedColumns, preapprovalColumns);
    }

    @When("the user set the realtor status field to {string}")
    public void the_user_set_the_realtor_status_field_to(String choice) {
      PreapprovalDetailsPage page =  new PreapprovalDetailsPage();
      page.clickCheckBoxForRealtor(choice);
        SeleniumUtils.waitFor(1);
       if(choice.equals("Yes"))
           page.getRealtorName().sendKeys("John Doe");
      page.getEstimatedPrice().sendKeys(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
        SeleniumUtils.waitFor(1);
      page.getDownpayment().sendKeys("10");
      page.getNextButton().click();
    }

    @Then("the corresponding column in the {string} table should be set to {int}")
    public void the_corresponding_column_in_the_table_should_be_set_to(String string, Integer int1) {
        List<List<Object>> result = DBUtils.getQueryResultAsListOfLists("select realtor_status from "+string);
         Assert.assertEquals(int1, result.get(result.size()-1).get(0));
    }

    @Then("each application should have a unique identifier in the {string} table")
    public void each_application_should_have_a_unique_identifier_in_the_table(String string) {
        List<List<Object>> ids = DBUtils.getQueryResultAsListOfLists("SELECT id FROM " + string);
        List<Integer> data = new ArrayList<Integer>();
        for(int i = 0; i <ids.size() - 1; i++) {
            data.add((Integer)(ids.get(i).get(0)) );
        }
        Collections.sort(data);
        boolean isDublicated = false;
        for(int i = 0; i <data.size() - 1; i++) {
            if (data.get(i).equals(data.get(i + 1))){
                isDublicated=true;
                break;
            }
        }
        Assert.assertFalse(isDublicated);
    }

    @Then("the user submit the whole application")
    public void the_user_submit_the_whole_application() {
        PersonalInformationPage personalInformationPage= new PersonalInformationPage();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        EmployementAndIncomePage employementAndIncomePage=new EmployementAndIncomePage();
        EconsentPage econsentPage = new EconsentPage();
        CreditReportPage creditReportPage = new CreditReportPage();
        personalInformationPage.getFirstName().sendKeys("Jhon" , Keys.TAB,  Keys.TAB,
                "Smith" ,Keys.TAB,  Keys.TAB, "tester.in.test.b12@gmail.com");

        SeleniumUtils.waitFor(1);
        personalInformationPage.getSsn().sendKeys("111111111" );
        SeleniumUtils.waitFor(1);
        personalInformationPage.getMaritalStatus1().click();
        personalInformationPage.getSearchMarried().sendKeys("Married", Keys.ENTER);
        personalInformationPage.getCellPhone().sendKeys("1234567890");
        preapprovalDetailsPage.getNextButton().click();
        new ExpensesPage().getPayment().sendKeys("1230");
        preapprovalDetailsPage.getNextButton().click();
        employementAndIncomePage.getFirstName().sendKeys("Joe Doe");
        employementAndIncomePage.getStartDate().sendKeys("12/01/2022", Keys.ENTER);
        employementAndIncomePage.getMonthlyIncome().sendKeys("3000000");
        preapprovalDetailsPage.getNextButton().click();
       // creditReportPage.getCheckbox().click();
        preapprovalDetailsPage.getNextButton().click();
        econsentPage.getFirstName().sendKeys("Jhon");
        econsentPage.getLastName().sendKeys("Smith");
        econsentPage.getEmail().sendKeys("tester.in.test.b12@gmail.com");
        preapprovalDetailsPage.getNextButton().click();
        econsentPage.getSaveB().click();

    }


    @Then("the data should be mapped correctly in the {string} table")
    public void the_data_should_be_mapped_correctly_in_the_table(String table) {
        List<Map<String, Object>> results = DBUtils.getQueryResultListOfMaps("SELECT realtor_status, realtor_info, purpose_loan, est_purchase_price, down_payment FROM " + table
        +" where b_email='tester.in.test.b12@gmail.com'");
        Assert.assertTrue(!results.isEmpty());
        Assert.assertEquals(1, results.get(0).get("realtor_status"));
        Assert.assertEquals(sharedData.getRealtorName(), results.get(0).get("realtor_info"));
        Assert.assertEquals("Purchase a Home", results.get(0).get("purpose_loan"));
      Assert.assertEquals(sharedData.getEstimatePurchasePrice(),Integer.valueOf((String)(results.get(0).get("est_purchase_price"))));
        //Assert.assertEquals(sharedData.getEstimatePurchasePrice(), Integer.(results.get(0).get("est_purchase_price"))); //bug
       // Assert.assertEquals(sharedData.getDownpayment(),results.get(0).get("down_payment")); //bug


//        Assert.assertEquals(1, results.get(results.size()-1).get("realtor_status"));
//        Assert.assertEquals(sharedData.getRealtorName(), results.get(results.size()-1).get("realtor_info"));
//        Assert.assertEquals("Purchase a Home", results.get(results.size()-1).get("purpose_loan"));
//        Assert.assertEquals(sharedData.getEstimatePurchasePrice(), results.get(0).get("est_purchase_price"));
//        Assert.assertEquals(sharedData.getDownpayment(), results.get(results.size()-1).get("down_payment"));

    }


    @Then("the user is cleaned up from the database")
    public void the_user_is_cleaned_up_from_the_database() throws SQLException {
      DBUtils.executeUpdate("DELETE from tbl_mortagage where b_email='tester.in.test.b12@gmail.com'");
    }




//    @When("the user insert {string} into the {string}")
//    public void the_user_insert_into_the(String inputData, String field) {
//
//
//    }
//    @Then("the data should be stored as a {string} in {string}")
//    public void the_data_should_be_stored_as_a_in(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


}
