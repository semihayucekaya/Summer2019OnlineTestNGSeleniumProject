package vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;


//we write extends TestBase to inherit @before and @AFTER methods
//this class will be dedicated to tests related to Login page only
//we don't have to find
public class LoginTests extends TestBase {
    @Test(description="Verify that page title is a'Dashboard'")
    public void Test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.login("storemanager85","UserUser123");


        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
    }

}
