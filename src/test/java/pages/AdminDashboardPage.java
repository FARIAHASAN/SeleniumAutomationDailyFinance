package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminDashboardPage {
    @FindBy(xpath = "//tbody/tr[1]/td")
    public  List<WebElement> userInfo;

    public AdminDashboardPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

}
