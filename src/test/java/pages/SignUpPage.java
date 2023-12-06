package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.NoSuchElementException;

@Data
public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="inputfirstname4")
    private WebElement firstName;

    @FindBy(id="inputlastname4")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="exampleInputPassword1")
    private WebElement password;

    @FindBy(id="emailerror")
    private WebElement emailError;

    @FindBy(id="register")
    private WebElement signUpButton;

   @FindBy(xpath ="//*[text()='Registration Successfull']" )
   private WebElement successMsg ;

    @FindBy(xpath ="//h4[@class='text-center mb-2']" )
    private WebElement pageHeader;

    @FindBy(id="emailerror")
    private WebElement emailerror;

    public WebElement getMsg(String str){
       return  Driver.getDriver().findElement(By.xpath("//*[contains(text(), '"+str+"')]"));
       //  return  Driver.getDriver().findElement(By.xpath("//*[text()='"+str+"']"));
    }

    public WebElement getField(String nameOfTheElement){
        switch (nameOfTheElement){
            case "First name": return firstName;
            case "Last name": return lastName;
            case "Email address": return email;
            case "Password": return password;
            default: throw new NoSuchElementException();
        }
    }







}
