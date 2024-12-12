package testRunners;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserDashboardPage;
import setup.CostModel;
import setup.SetUp;
import utils.Utils;

import java.io.IOException;

public class UserDashboardTestRunner extends SetUp {
    @BeforeTest
    public void doUserLogin() throws IOException, ParseException {
        LoginPage login = new LoginPage(driver);
        JSONObject object =Utils.getLastUserInfo();
       String email= (String) object.get("email");
        String password = (String) object.get("password");
        login.doLogin(email,password);

    }
    @Test(priority = 1,description = "Add New Cost")
    public void addNewCost() throws IOException, InterruptedException {
        UserDashboardPage userDashboard = new UserDashboardPage(driver);

        for (int i=1;i<=5;i++)
        {
            String[] rowData= Utils.getCostData(i) ;
            CostModel costmodel = new CostModel();
            costmodel.setItem_name(rowData[0]);
            costmodel.setQuantity(rowData[1]);
            costmodel.setAmount(rowData[2]);
            costmodel.setPurchase_date(rowData[3]);
            costmodel.setMonth(rowData[4]);
            costmodel.setRemarks(rowData[5]);
            userDashboard.addNewCost(costmodel);
            Thread.sleep(5000);
            driver.switchTo().alert().accept();

        }
    }
    @Test(priority = 2,description = "Check Total Amount")
    public void dochechTotalAmount()
    {
        UserDashboardPage userDashboard = new UserDashboardPage(driver);

        String expectedTotalAmount="35120.66";
        String actualTotalAmount= userDashboard.txtTotalAmount.getText();
        Assert.assertTrue(actualTotalAmount.contains(expectedTotalAmount));


    }
    @Test(priority = 3,description = "Chech Search Product Amount")
    public void dochechSearchProductAmount()
    {
        UserDashboardPage userDashboard = new UserDashboardPage(driver);
        userDashboard.txtSearchProduct.sendKeys("phone");
        String expectedSearchAmount="33000";
        String actualSearchAmount= userDashboard.txtTotalAmount.getText();
        Assert.assertTrue(actualSearchAmount.contains(expectedSearchAmount));


    }
}
