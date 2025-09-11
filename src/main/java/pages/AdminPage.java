package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUserTex;

    @FindBy(linkText = "Admin")
    WebElement AdminLink;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addUsrButton;

    @FindBy(xpath = "//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]")
    WebElement userRoleDropdown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employerName;

    @FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
    WebElement statusDropdown;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    WebElement userNameTextField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement userSaveButton;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement getEmployerName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;



    public void goAdminPage() {
        AdminLink.click();
    }

    public boolean isSystemUserCardDisplay() {
        return systemUserTex.isDisplayed();
    }

    public boolean isAdminPageLoaded() {
        return driver.getCurrentUrl().contains("viewSystemUsers");
    }

    //  Generic dropdown selector
    private void selectDropdownValue(WebElement dropdown, String optionText) {
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@role='listbox']//span[normalize-space()='" + optionText + "']")));
        option.click();
    }

    public void selectUserRole(String role) {
        selectDropdownValue(userRoleDropdown, role);
    }

    public void selectStatus(String status) {
        selectDropdownValue(statusDropdown, status);
    }

    public void addUser(String role,String empName, String status,String Password, String comfPassword ) {
        addUsrButton.click();
        selectUserRole(role);   // or "ESS"
        employerName.sendKeys(empName);
        selectStatus(status);   // or "Disabled"
        userNameTextField.sendKeys(status);
        password.sendKeys(Password);
        confirmPassword.sendKeys(comfPassword);
        userSaveButton.click();
    }

//    public  void searchSystemUser(){
//        userNameTextField.sendKeys("sahan");
//        selectUserRole("Admin");
//        employerName.sendKeys("Peter Anderson");
//        selectStatus("Enabled");
//        //searchButton.click();
//    }
}
