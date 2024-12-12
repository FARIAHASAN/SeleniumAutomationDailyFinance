package setup;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SetUp {
    public WebDriver driver;
    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "/Users/faria/Downloads/geckodriver");
         driver = new FirefoxDriver();
       // System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
       // driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://dailyfinance.roadtocareer.net/");
    }

   // @AfterTest
    public void closeDriver()
    {
        driver.quit();
    }
}
