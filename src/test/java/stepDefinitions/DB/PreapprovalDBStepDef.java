package stepDefinitions.DB;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PreapprovalDetailsPage;
import stepDefinitions.SharedData;
import utils.DBUtils;
import utils.SeleniumUtils;

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

    @Then("the data should be mapped correctly in the {string} table")
    public void the_data_should_be_mapped_correctly_in_the_table(String table) {
        List<Map<String, Object>> results = DBUtils.getQueryResultListOfMaps("SELECT realtor_status, realtor_info, purpose_loan, est_purchase_price, down_payment FROM " + table);
        Assert.assertTrue(!results.isEmpty());
        Assert.assertEquals(1, results.get(results.size()-1).get("realtor_status"));
        Assert.assertEquals(sharedData.getRealtorName(), results.get(results.size()-1).get("realtor_info"));
        Assert.assertEquals("Purchase a Home", results.get(results.size()-1).get("purpose_loan"));
        Assert.assertEquals(sharedData.getEstimatePurchasePrice(), results.get(0).get("est_purchase_price"));
        Assert.assertEquals(sharedData.getDownpayment(), results.get(results.size()-1).get("down_payment"));

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
