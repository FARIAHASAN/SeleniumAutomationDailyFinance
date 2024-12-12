package testRunners;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import setup.SetUp;
import setup.UserModel;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class RegistrationTestRunner  extends SetUp {
    @Test(priority = 1, description = "Registration Without Mandatory Info")
    public void doRegistrationWithoutMandatoryInfo() throws InterruptedException, IOException, ParseException {
        RegistrationPage register = new RegistrationPage(driver);
        LoginPage  loginpage = new  LoginPage(driver);
        loginpage.linkRegister.click();

        UserModel model = new UserModel();
        Faker faker = new Faker();

        String lastName = faker.name().lastName();

        String address = faker.address().fullAddress();

        model.setLastName(lastName);
        model.setAddress(address);
        register.doRegistration(model);
    String shrink_value=register.labelFirstName.getAttribute("data-shrink");
    Assert.assertEquals(shrink_value,"true","Field validation did not trigger as expected.");
        driver.navigate().back();


    }
    @Test(priority = 3, description = "Registration With All Info")
    public void doRegistrationWithAllInfo() throws InterruptedException, IOException, ParseException {
        RegistrationPage register = new RegistrationPage(driver);
        LoginPage  loginpage = new  LoginPage(driver);
        loginpage.linkRegister.click();

        UserModel model = new UserModel();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName+ Utils.randomNumber(100,999) +"@gmail.com";
        String password = faker.internet().password();
        String address = faker.address().fullAddress();
        String phoneNumber ="015733"+Utils.randomNumber(10000,99999) ;
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setEmail(email);
        model.setPassword(password);
        model.setAddress(address);
        model.setPhoneNumber(phoneNumber);
        model.setGender(1);
        model.setCheck(true);
        register.doRegistration(model);
        registerAssertion();
        JSONObject object = new JSONObject();
        object.put("firstName",firstName);
        object.put("lastName",lastName);
        object.put("email",email);
        object.put("phoneNumber",phoneNumber);
        object.put("address",address);


        if(model.getGender()==0)
            object.put("gender","Male");
        else  object.put("gender","Female");

        object.put("password",password);


Utils.setUserInfo(object);

    }
    @Test(priority = 2, description = "Registration With Mandatory Infos")
    public void doRegistrationWithMandatoryInfo() throws InterruptedException, IOException, ParseException {
        RegistrationPage register = new RegistrationPage(driver);
        LoginPage  loginpage = new  LoginPage(driver);
        loginpage.linkRegister.click();
        UserModel model = new UserModel();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String email = firstName+ Utils.randomNumber(100,999) +"@gmail.com";
        String password = faker.internet().password();
        String phoneNumber ="015733"+Utils.randomNumber(10000,99999) ;
        model.setFirstName(firstName);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhoneNumber(phoneNumber);
        model.setGender(1);
        model.setCheck(true);
        register.doRegistration(model);
        registerAssertion();
        JSONObject object = new JSONObject();
        object.put("firstName",firstName);
        object.put("email",email);
        object.put("phoneNumber",phoneNumber);
        object.put("password",password);

        if(model.getGender()==0)
            object.put("gender","Male");
        else  object.put("gender","Female");




        Utils.setUserInfo(object);

    }
    private void registerAssertion() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated( By.className("Toastify__toast")));
        String actualtxt = driver.findElement(By.className("Toastify__toast")).getText();
        String expectedtxt="successfully";
        Assert.assertTrue(actualtxt.contains(expectedtxt));

    }
}
