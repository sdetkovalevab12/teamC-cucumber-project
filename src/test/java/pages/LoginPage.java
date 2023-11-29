package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class LoginPage {


    public LoginPage(){ PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "exampleInputEmail1")
    private WebElement emailInput;

    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]")
    private WebElement errorText;



}
