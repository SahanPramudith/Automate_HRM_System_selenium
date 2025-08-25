package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUserTex;
    @FindBy(linkText = "Admin")
    WebElement AdminLink;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement adduserButton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]")
    WebElement drpDown;
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement admin;
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    WebElement selectedVal;
    public void goAdminPage() {
        AdminLink.click();
    }

    public boolean isSystemUserCardDisplay() {
        return systemUserTex.isDisplayed();
    }

    public boolean isAdminPageLord() {
        return driver.getCurrentUrl().contains("viewSystemUsers");
    }

    public void selectDropdownOption() throws InterruptedException {
        drpDown.click();
        admin.click();
        System.out.println("selectedVal"+selectedVal.getText());


    }
}

