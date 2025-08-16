package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement button;
    @FindBy(xpath = "//img[@alt='company-branding']")
    WebElement logo;
    @FindBy(xpath = "//div[@class='orangehrm-login-logo-mobile']//img[@alt='orangehrm-logo']")
    WebElement  logoIcon;

    public void setPassword(String Password){
        password.sendKeys(Password);
    }
    public void setUserName(String usrName){
        userName.sendKeys(usrName);
        System.out.println("usrName = " + usrName);
    }
    public  void clickButton() throws InterruptedException {
        button.click();
    }

    public boolean isBrandLogoDisPlay(){
        return logo.isDisplayed();
    }
    public boolean isLogoIconDisPlay(){
        return logoIcon.isDisplayed();
    }
    public boolean isUserTexFiledDisPlay(){
        return userName.isDisplayed();
    }
    public boolean isPasswordFiledDisPlay(){
        return password.isDisplayed();
    }
    public boolean isSubmitButtonDisPlay(){
        return button.isDisplayed();
    }


}
