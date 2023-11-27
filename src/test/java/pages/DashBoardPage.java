package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class DashBoardPage {
    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='brand-logo']")
    private WebElement logo;

    @FindBy(xpath = "//span[@class='user-name']")
    private WebElement fullName;

    @FindBy(xpath = "//img[@alt='avatar']")
    private WebElement photo;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right pb-0 show']")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    private WebElement logOutLink;



    public WebElement getLeftMenuElement(String str){
     return  Driver.getDriver().findElement(By.xpath("//span[@class='menu-item'][.='"+str+"']"));
    }

}
