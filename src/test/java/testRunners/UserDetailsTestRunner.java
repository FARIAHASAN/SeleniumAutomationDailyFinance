package testRunners;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserDashboardPage;
import pages.UserDetailsPage;
import setup.SetUp;
import utils.Utils;

import java.io.IOException;

public class UserDetailsTestRunner  extends SetUp {
    @BeforeTest
    public void doUserLogin() throws IOException, ParseException {
        LoginPage login = new LoginPage(driver);
        JSONObject object = Utils.getLastUserInfo();
        String email= (String) object.get("email");
        String password = (String) object.get("password");
        login.doLogin(email,password);
    }
    @Test(priority = 1,description = "Upload User Photo")
    public void doUploadImage() throws InterruptedException {
        UserDashboardPage userDashboard = new UserDashboardPage(driver);
        userDashboard.btnProfileIcon.click();
        userDashboard.ProfileMenuItems.get(0).click();
        String image_location=System.getProperty("user.dir")+"/src/test/resources/testdata/user2.jpeg";
        UserDetailsPage userDetails = new UserDetailsPage(driver);

        //uploading image
        userDetails.doUploadImage(image_location);

        Thread.sleep(4000);
        String actualMsg= driver.switchTo().alert().getText();
        String expectedMsg="successfully";
        driver.switchTo().alert().accept();
        Assert.assertTrue(actualMsg.contains(expectedMsg));



        //updating info
        userDetails.btnUpdate.click();
        Thread.sleep(4000);
        actualMsg= driver.switchTo().alert().getText();
        expectedMsg="successfully";
        driver.switchTo().alert().accept();
        Assert.assertTrue(actualMsg.contains(expectedMsg));




    }
}
