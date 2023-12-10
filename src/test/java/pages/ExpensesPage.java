package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class ExpensesPage {
    public ExpensesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="monthlyrentalpayment")
    private WebElement payment;



}
