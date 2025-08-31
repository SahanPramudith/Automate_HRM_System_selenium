import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyInfo;

public class MyInfoPageTest extends BaseTest {

    @Test
    public void isMyInfoPageLord() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MyInfo myInfo = new MyInfo(driver);
        myInfo.goMyInfo();
        Assert.assertTrue(myInfo.isLordPage(),"BUG : My Info  Page Lord Attempt Fail ");
    }
    @Test
    public void personalDetails() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MyInfo myInfo = new MyInfo(driver);
        myInfo.goMyInfo();
        //----------------------------------------------------------

       // myInfo.personalDetails();
        myInfo.contactDetails();
    }
}
