import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class AdminPageTest extends BaseTest {

    
    @Test
    public void isAdminPageLord() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goAdminPage();
        Thread.sleep(3000);
       Assert.assertTrue(adminPage.isAdminPageLoaded(),"BUG:viewSystemUsers view Attempt fail");
    }

    @Test
    public void addUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goAdminPage();
        adminPage.addUser();

    }

}
