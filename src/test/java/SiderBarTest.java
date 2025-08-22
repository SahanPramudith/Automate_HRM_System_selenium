import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideBarPage;

public class SiderBarTest extends BaseTest {

    @Test
    public void isDisplaySideBar() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        SideBarPage sideBar = new SideBarPage(driver);
        Assert.assertTrue(sideBar.isDashboardListDisplay(),"BUG:side bar is not displayed");
    }
}
