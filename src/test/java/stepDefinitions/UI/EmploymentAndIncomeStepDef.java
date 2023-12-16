package stepDefinitions.UI;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.EmployementAndIncomePage;
import utils.SeleniumUtils;

import java.util.List;

public class EmploymentAndIncomeStepDef {

    @When("the user is redirected to the {string}")
    public void the_user_is_redirected_to_the(String string) {
        Assert.assertEquals(new EmployementAndIncomePage().getCurrentSectionSelection(string)
                .getAttribute("aria-selected"), "true");
    }

    @Then("the Employer {int} should contain the following fileds")
    public void the_employer_should_contain_the_following_fileds(Integer int1, List<String> dataTable) {
       EmployementAndIncomePage page = new EmployementAndIncomePage();
    // dataTable.forEach(s-> Assert.assertTrue(page.getEmployerSections(s,int1).isDisplayed()));
        dataTable.forEach(s-> Assert.assertTrue(page.getEmployerSections(s,int1).isEnabled()));
    }

    @Then("dropdown should have {int} states")
    public void dropdown_should_have_states(Integer int1) {
        Select select = new Select(new EmployementAndIncomePage().getStateDropDown());
       Assert.assertEquals(int1+1,select.getOptions().size());

    }
    @Then("dropdown options should have two-letter abbreviations")
    public void dropdown_options_should_have_two_letter_abbreviations() {
        Select select = new Select(new EmployementAndIncomePage().getStateDropDown());
        List<String> elementsText = SeleniumUtils.getElementsText(select.getOptions());
        SoftAssertions softAssertions = new SoftAssertions();
        elementsText.removeIf(s->s.equals("Select One"));
        for (int i=0; i<= elementsText.size(); i++){
            String abbriviation= elementsText.get(i).substring(elementsText.get(i).length()-4);
            System.out.println(abbriviation);
            System.out.println(abbriviation.length());
            System.out.println(abbriviation.charAt(0)=='(');
            System.out.println(abbriviation.charAt(abbriviation.length()-1)==')');
            softAssertions.assertThat(abbriviation.length()).isEqualTo(4);
            softAssertions.assertThat(abbriviation.charAt(0)).isEqualTo('(');
           // softAssertions.assertThat(abbriviation.charAt(abbriviation.length()-1)==')');
        }
        softAssertions.assertAll();
    }
    @Then("checkbox labeled {string} should be unchecked")
    public void checkbox_labeled_should_be_unchecked(String string) {
       Assert.assertFalse(new EmployementAndIncomePage().getCheckBox().isSelected());
    }

    @When("the user fill out all required fields on Emploement Page")
    public void the_user_fill_out_all_required_fields_on_emploement_page() {
        EmployementAndIncomePage page = new EmployementAndIncomePage();
        Faker faker=new Faker();
        if(!page.getCheckBox().isSelected())
            page.getCheckBox().click();
        page.getFirstName().sendKeys(faker.name().firstName());
        page.getStartDate().sendKeys("12/01/2022", Keys.ENTER);
        page.getMonthlyIncome().sendKeys("11111111");
    }
    @Then("the user click Clear")
    public void a_warning_pop_up_is_displaed() {

        SeleniumUtils.jsClick(new EmployementAndIncomePage().getClearButton());
    }


    @Then("the user click Yes!")
    public void click_Yes() {

        SeleniumUtils.jsClick(new EmployementAndIncomePage().getYes());
    }
    @Then("information from section is removed")
    public void information_from_section_is_removed() {
        EmployementAndIncomePage page = new EmployementAndIncomePage();
        Assert.assertNull(page.getFirstName().getAttribute("value"));
        Assert.assertNotNull(page.getMonthlyIncome().getAttribute("value"));
    }

}
