package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfo {

    WebDriver driver;
    WebDriverWait wait;
    public MyInfo(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @FindBy(linkText = "My Info")
    WebElement myInfoLink;

    @FindBy(partialLinkText = "Personal Details")
    WebElement personalDetailsLink;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameTextField;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleNameTextField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameTextField;

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

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement homeTextFiled ;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement MobileTextFiled ;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/input[1]")
    WebElement workTextFiled ;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement emailTextField ;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement otherEmailTextField ;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton ;

    @FindBy(xpath = "//form[@class='oxd-form']//input[1]")
    WebElement employerIdTextFiled ;

     @FindBy(xpath = "//label[text()='Other Id']/following::input[1]")
     WebElement OtherId ;

     @FindBy(xpath = "//div[contains(@class,'oxd-select-text')]")
     WebElement countyDropdown ;



    public void goMyInfo(){
        myInfoLink.click();
    }
    public boolean isLordPage(){
        return driver.getCurrentUrl().contains("viewPersonalDetails");
    }


    public void contactDetails() throws InterruptedException {
     //   WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        contactDetailsLink.click();
        contactDetailsAddress1.sendKeys("Matara");
        contactDetailsAddress2.sendKeys("gandara");
        Thread.sleep(3000);
        contactDetailsStreet.sendKeys("gandara");
        province.sendKeys("south");
        zipCode.sendKeys("2040");
        WebElement drpdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropDown));
        drpdown.click();
        sriLanka.click();
        homeTextFiled.sendKeys("0741600386");
        MobileTextFiled.sendKeys("0751600386");
        workTextFiled.sendKeys("0751600386");
        emailTextField.sendKeys("sahan@gmail.com");
        otherEmailTextField.sendKeys("sahanpramudith@gmail.com");
        saveButton.click();
        Thread.sleep(3000);

    }

    public void personalDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        firstName.clear();
        firstName.sendKeys("sahan");
        Thread.sleep(3000);
        middleNameTextField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        middleNameTextField.sendKeys("lakeesha");
       // Thread.sleep(30000);
        lastNameTextField.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
        lastNameTextField.sendKeys("pramudith");
        employerIdTextFiled.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
        employerIdTextFiled.sendKeys("emp1000");
        OtherId.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
        OtherId.sendKeys("sahan12");
        serCountry("Cambodian");
        Thread.sleep(3000);
    }

    public void dropDown(WebElement webElement, String option){
//        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        WebElement clickOption = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//div[@role='listbox']//span[normalize-space()='" + option + "']")));
        clickOption.click();
    }

    public void serCountry(String country){
        dropDown(countyDropdown,country);
    }


}
