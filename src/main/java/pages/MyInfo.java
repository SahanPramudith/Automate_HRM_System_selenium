package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo {

    WebDriver driver;
    public MyInfo(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "My Info")
    WebElement myInfoLink;

    public void goMyInfo(){
        myInfoLink.click();
    }
    public boolean isLordPage(){
        return driver.getCurrentUrl().contains("viewPersonalDetails");
    }
}
