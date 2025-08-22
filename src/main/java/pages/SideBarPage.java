package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBarPage {
    WebDriver driver;
    public SideBarPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='oxd-main-menu']")
    WebElement dashboardList;

    public boolean isDashboardListDisplay(){
        return dashboardList.isDisplayed();
    }
    
}
