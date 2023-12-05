package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class OrderCreditReport {

    public OrderCreditReport(){PageFactory.initElements(Driver.getDriver(),this);}


  @FindBy(xpath = "//*[@id=\"steps-uid-0-p-4\"]/div/div/div/ul/li[1]/fieldset/div")
    private WebElement checkBoxYes;



}
