package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import setup.CostModel;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.split;

public class UserDashboardPage {
    @FindBy(xpath ="//button/*[@data-testid='AccountCircleIcon']" )
   public WebElement btnProfileIcon;
    @FindBy(xpath ="//li[@role='menuitem']")
   public List<WebElement> ProfileMenuItems;
    @FindBy(className="add-cost-button")
    public WebElement btnAddCost;

    @FindBy(xpath ="//button[contains(text(),'+')]" )
    public WebElement btnQuantity;
    @FindBy(xpath ="//button[contains(text(),'Submit')]" )
    public WebElement btnSubmit;

    @FindBy(id="itemName")
    public WebElement txtItemName;
    @FindBy(id="amount")
    public WebElement txtAmount;
    @FindBy(id="remarks")
    public WebElement txtRemarks;
    @FindBy(id="month")
    public WebElement dropdownMonth;
    @FindBy(id="purchaseDate")
    public WebElement datePurchase;

    @FindBy(xpath = "//div[@class='summary']/span[2]")
    public WebElement txtTotalAmount;
    @FindBy(className = "search-input")
    public WebElement txtSearchProduct;

    public  UserDashboardPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

public void addNewCost(CostModel model) throws InterruptedException {
String item_name=model.getItem_name();
int quantity= Double.valueOf(model.getQuantity()).intValue();
String amount=model.getAmount();
String purchase_date=model.getPurchase_date();
String month=model.getMonth();
String remark=model.getRemarks();
String[] dateMonthYear=purchase_date.split("/");

btnAddCost.click();

txtItemName.sendKeys(item_name);

    for(int i=0;i<quantity;i++)
    {
        btnQuantity.click();
    }

txtAmount.sendKeys(amount);

    //datePurchase.click();

   // datePurchase.sendKeys(purchase_date);
Select dropdown = new Select(dropdownMonth);
dropdown.selectByVisibleText(capitalize(month));

    txtRemarks.sendKeys(remark);

btnSubmit.click();
}


}
