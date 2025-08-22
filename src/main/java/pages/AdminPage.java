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

    public AdminPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUserTex;
    @FindBy(linkText = "Admin")
    WebElement AdminLink;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement adduserButton;
    @FindBy(xpath = "//div[contains(@class,'oxd-select-text')])[1]")
    WebElement droDown;
    @FindBy(xpath = "//div[@role='option']")
    WebElement dropDownMenu;

    public void goAdminPage(){
        AdminLink.click();
    }
    public boolean isSystemUserCardDisplay(){
        return systemUserTex.isDisplayed();
    }
    public boolean isAdminPageLord(){
       return driver.getCurrentUrl().contains("viewSystemUsers");
    }

    public void selectDropdownOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userRoleDropdown = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]")));
        userRoleDropdown.click();

// Step 2: Get all options when expanded
        List<WebElement> options = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

// Print option texts (just to track values)
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }

    }



}
