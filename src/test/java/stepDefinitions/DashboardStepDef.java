package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.DashBoardPage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class DashboardStepDef {

    @Given("the user logs in into account")
    public void the_user_logs_in_into_account() {
        SignInPage signInPage= new SignInPage();
        signInPage.getEmail().sendKeys(ConfigReader.getProperty("email"), Keys.TAB,
                ConfigReader.getProperty("password"), Keys.ENTER);
    }

    @Then("the bank's logo should be displayed")
    public void the_bank_s_logo_should_be_displayed() {
        Assert.assertTrue(new DashBoardPage().getLogo().isDisplayed());
    }
    @Then("the dashboard page should include following links:")
    public void the_dashboard_page_should_include_following_links(List<String> dataTable) {
       for(int i=0; i<dataTable.size(); i++){
         Assert.assertTrue(new DashBoardPage().getLeftMenuElement(dataTable.get(i)).isDisplayed());
        }
    }
    @When("the user click {string}")
    public void the_user_click(String string) {
        Driver.getDriver().findElement(By.linkText(string)).click();
    }
    @Then("the user should be redirected to {string}")
    public void the_user_shoud_be_redirected_to(String string) {
        Assert.assertEquals(string, Driver.getDriver().getCurrentUrl());
    }
    @Then("The user's account information should be displayed in the top right corner of the page")
    public void the_user_s_account_information_should_be_displayed_in_the_top_right_corner_of_the_page(){
     DashBoardPage dashBoardPage= new DashBoardPage();
        String[] fullName = dashBoardPage.getFullName().getText().split(" ");
        Assert.assertTrue(fullName[0].equals(ConfigReader.getProperty("firstName")));
        Assert.assertTrue(fullName[1].equals(ConfigReader.getProperty("lastName")));
        Assert.assertTrue(dashBoardPage.getPhoto().isDisplayed());
    }
    @When("the user click on the user name")
    public void the_user_click_on_the_user_name() {
        new DashBoardPage().getFullName().click();
    }
    @Then("dropdown menu should display a {string} link")
    public void dropdown_menu_should_display_a_link(String string) {
        SeleniumUtils.waitForPageToLoad(5);
       Assert.assertTrue(new DashBoardPage().getLogOutLink().isDisplayed());
    }

}
