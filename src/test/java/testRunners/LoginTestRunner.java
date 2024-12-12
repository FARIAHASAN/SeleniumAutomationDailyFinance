package testRunners;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.SetUp;

public class LoginTestRunner extends SetUp {
    @Test(priority = 1,description = "Admin login")
    public void doAdminLogin()
    {
        LoginPage loginpage = new LoginPage(driver);
        if(System.getProperty("email")==null)
            System.setProperty("email","admin@test.com");
        if(System.getProperty("password")==null)
            System.setProperty("password","admin123");

        loginpage.doLogin(System.getProperty("email"),System.getProperty("password"));

        String txtExpected="Admin Dashboard";
        String txtActual=loginpage.txtHeaderDashBoard.getText();
        Assert.assertTrue(txtActual.equals(txtExpected));

    }




}
