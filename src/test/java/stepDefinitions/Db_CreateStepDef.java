package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DBUtils;

import java.sql.SQLException;

public class Db_CreateStepDef {
    @Given("The new  user with new credential created in DB")
    public void theNewUserWithNewCredentialCreatedInDB() throws SQLException {

        Faker faker = new Faker();

        String query ="INSERT INTO tbl_user(id,email, password, first_name, last_name, phone, type,church_id, country_id ) values"+
                "(11110 ,\""+faker.internet().emailAddress()+"\",\"d0b4449cf30599ceb527201ec5a86ef7\",\"+" +
                ""+faker.name().firstName()+"\",\""+faker.name().lastName()+"\",\""+faker.phoneNumber()+"\" ,1,1,1)";

        System.out.println(query);

        DBUtils.executeUpdate(query);
    }

    @When("The user in with the same credential")
    public void theUserInWithTheSameCredential() {
    }

    @Then("The user should be able to log in")
    public void theUserShouldBeAbleToLogIn() {
    }


}
