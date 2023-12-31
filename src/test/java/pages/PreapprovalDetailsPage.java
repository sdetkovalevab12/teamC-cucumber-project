package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class PreapprovalDetailsPage {

    public PreapprovalDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//label[@for='realtor2']")
    private WebElement noForRealtor;

    @FindBy(id="estimatedprice")
    private  WebElement estimatedPrice;

    @FindBy(xpath = "//input[@id='downpayment']")
    private  WebElement downpayment;

    @FindBy(xpath ="//a[@href='#next']")
    private  WebElement nextButton;

    @FindBy(id="realtorinfo")
    private  WebElement realtorName;

    public void clickCheckBoxForRealtor(String str){
       WebElement box = Driver.getDriver().findElement(By.xpath("//label[text()='"+str+"']"));
        if(!box.isSelected()){
           box.click();
        }
    }


}
