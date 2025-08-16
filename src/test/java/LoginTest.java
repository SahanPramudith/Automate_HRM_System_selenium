import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickButton();
        Thread.sleep(3000);
        boolean dashboard = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(dashboard,"login attempt  fail");
    }

    @Test
    public void incorrectCredential() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Admi");
        loginPage.setPassword("admin123");
        loginPage.clickButton();
        Thread.sleep(3000);
        boolean dashboard = driver.getCurrentUrl().contains("dashboard");
        //// assert fail if dashboard came up after invalid login
        Assert.assertFalse(dashboard,"BUG: User got logged in with invalid credentials!\"");

    }
    @Test
    public void verifyLoginPageElements() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(3000);

        //title
        Assert.assertEquals(driver.getTitle(),"OrangeHRM","This title match ");
        //isBrandLogoDisPlay
        Assert.assertTrue(loginPage.isBrandLogoDisPlay(),"is not Display");
        //isLogoIconDisPlay
      //  Assert.assertTrue(loginPage.isLogoIconDisPlay(),"is not Display");
        Assert.assertTrue(loginPage.isUserTexFiledDisPlay(),"is not Display");
        Assert.assertTrue(loginPage.isPasswordFiledDisPlay(),"is not Display");
        Assert.assertTrue(loginPage.isSubmitButtonDisPlay(),"is not Display");

    }
}
