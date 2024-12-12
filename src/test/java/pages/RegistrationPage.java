package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.UserModel;

import java.util.List;

public class RegistrationPage  {

    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id = "lastName")
    WebElement txtLastName;
    @FindBy(id = "phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(id = "address")
    WebElement txtAddress;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> radioGender;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxTerm;

    @FindBy(id = "register")
    WebElement btnRegister;
@FindBy(id = "firstName-label")
public WebElement labelFirstName;

    public RegistrationPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
public void  doRegistration(UserModel model)
{

    String firstName = model.getFirstName();
    String lastName = model.getLastName();
    String email = model.getEmail();
    String password = model.getPassword();
    String address = model.getAddress();
    String phoneNumber = model.getPhoneNumber();
   int gender = model.getGender();
   boolean term = model.isCheck();

txtFirstName.sendKeys(firstName!=null?firstName:"");
txtLastName.sendKeys(lastName!=null?lastName:"");
txtEmail.sendKeys(email!=null?email:"");
txtPassword.sendKeys(password!=null?password:"");
txtAddress.sendKeys(address!=null?address:"");
txtPhoneNumber.sendKeys(phoneNumber!=null?phoneNumber:"");
if( gender ==0 || gender ==1 )
{
    radioGender.get(gender).click();
}
if(term) {
    checkboxTerm.click();
}
btnRegister.click();

}
}
