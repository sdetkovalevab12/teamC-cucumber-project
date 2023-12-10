package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class EmployementAndIncomePage {
    public EmployementAndIncomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@role='tab']//span[text()= 'Employment and Income']")
    private WebElement employmentIcone;

    @FindBy(id = "state1")
    private WebElement stateDropDown;

    @FindBy(id = "currentjob1")
    private WebElement checkBox;

    @FindBy(id = "employername1")
    private WebElement firstName;

    @FindBy(id = "start_date1")
    private WebElement startDate;

    @FindBy(id = "grossmonthlyincome")
    private WebElement monthlyIncome;

    @FindBy(id = "clear1")
    private WebElement clearButton;

    @FindBy(xpath = "//*[text()='Yes!']")
    private WebElement yes;





    public WebElement getCurrentSectionSelection(String sectionName){
        return Driver.getDriver().findElement(By.xpath("//li[@role='tab']//span[text()='"+sectionName+"']//ancestor::li"));
    }


    public WebElement getEmployerSections(String str, Integer num){
        System.out.println("//div[@id='employer"+num+"']//label[text()='"+str+"']");
      return  Driver.getDriver().findElement(By.xpath( "//div[@id='employer"+num+"']//label[text()='"+str+"']"));
    }
}
