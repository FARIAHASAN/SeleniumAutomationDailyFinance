package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {

    @FindBy(xpath ="//button[contains(text(),'Edit')]")
    public WebElement btnEdit;
    @FindBy(className ="upload-input")
    public WebElement input_file;
    @FindBy(xpath ="//button[contains(text(),'Upload Image')]")
    public WebElement btnUpload;
    @FindBy(xpath ="//button[contains(text(),'Update')]")
    public WebElement btnUpdate;

    public  UserDetailsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void doUploadImage(String image_location)
    {
btnEdit.click();
input_file.sendKeys(image_location);
btnUpload.click();
    }
}
