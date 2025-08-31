package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfo {

    WebDriver driver;
    public MyInfo(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "My Info")
    WebElement myInfoLink;

    @FindBy(partialLinkText = "Personal Details")
    WebElement personalDetailsLink;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameTextField;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[1]//div[1]//div[2]//input[1]")
    WebElement contactDetailsAddress1 ;

    @FindBy(linkText = "Contact Details")
    WebElement contactDetailsLink ;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[2]//div[1]//div[2]//input[1]")
    WebElement contactDetailsAddress2 ;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[3]//div[1]//div[2]//input[1]")
    WebElement contactDetailsStreet ;

    @FindBy(xpath = "//div[4]//div[1]//div[2]//input[1]")
    WebElement province ;

    @FindBy(xpath = "//div[5]//div[1]//div[2]//input[1]")
    WebElement zipCode ;

    @FindBy(xpath = "//span[normalize-space()='Sri Lanka']")
    WebElement country ;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    WebElement countryDropDown;

    @FindBy(xpath = "//span[normalize-space()='Sri Lanka']")
    WebElement sriLanka ;



    public void goMyInfo(){
        myInfoLink.click();
    }
    public boolean isLordPage(){
        return driver.getCurrentUrl().contains("viewPersonalDetails");
    }

//    public void personalDetails() throws InterruptedException {
//        personalDetailsLink.click();
//        firstNameTextField.sendKeys("sahan");
//        WebElement firstNameTextField1 = firstNameTextField;
//        System.out.println("firstNameTextField1 = " + firstNameTextField1);
//
//        Thread.sleep(5000);
//
//    }


    public void contactDetails() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        contactDetailsLink.click();
        contactDetailsAddress1.sendKeys("Matara");
        contactDetailsAddress2.sendKeys("gandara");
        Thread.sleep(3000);
        contactDetailsStreet.sendKeys("gandara");
        province.sendKeys("south");
        zipCode.sendKeys("2040");
        WebElement drpdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(countryDropDown));
        drpdown.click();
        sriLanka.click();
    }

}
