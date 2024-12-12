package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public  WebElement linkRegister;
    @FindBy(xpath = "//h2[contains(text(),'Admin Dashboard')]")
    public WebElement txtHeaderDashBoard;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void doLogin(String email,String password)
    {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
}
