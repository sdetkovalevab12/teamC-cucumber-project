package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class EconsentPage {

    public EconsentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="eConsentdeclarerFirstName")
    private WebElement firstName;

    @FindBy(id="eConsentdeclarerLastName")
    private WebElement lastName;

    @FindBy(id="eConsentdeclarerEmail")
    private WebElement email;

    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement saveB;

}
