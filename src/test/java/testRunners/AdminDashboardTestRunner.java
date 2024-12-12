package testRunners;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminDashboardPage;
import pages.LoginPage;
import setup.SetUp;
import utils.Utils;

import java.io.IOException;


public class AdminDashboardTestRunner extends SetUp {

    @BeforeTest
    public void adminLogin()
    {
        LoginPage loginpage = new LoginPage(driver);
//        if(System.getProperty("email")==null)
//            System.setProperty("email","admin@test.com");
//        if(System.getProperty("password")==null)
//            System.setProperty("password","admin123");
        loginpage.doLogin("admin@test.com","admin123");
    }
    @Test(priority  =1,description = "Check info of last Registered User")
    public void doCheckUserInfo() throws IOException, ParseException {

      JSONObject object = Utils.getLastUserInfo();
        AdminDashboardPage admin = new AdminDashboardPage(driver);
      String FirstName = admin.userInfo.get(0).getText();
        String LastName = admin.userInfo.get(1).getText();
        String Email	= admin.userInfo.get(2).getText();
        String PhoneNumber = admin.userInfo.get(3).getText();
        String Address = admin.userInfo.get(4).getText();
        String Gender = admin.userInfo.get(5).getText();

       Assert.assertTrue(FirstName.equals(object.get("firstName")));
       Assert.assertTrue(LastName.equals(object.get("lastName")));
        Assert.assertTrue(Email.equals(object.get("email")));
        Assert.assertTrue(PhoneNumber.equals(object.get("phoneNumber")));
        Assert.assertTrue(Address.equals(object.get("address")));
        Assert.assertTrue(Gender.equals(object.get("gender")));

    }

}
