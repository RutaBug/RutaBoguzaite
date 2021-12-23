package baseUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseUITest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    }

    @BeforeMethod
    public void openWebPage(){
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    @AfterSuite
    public void driverQuit(){
        driver.quit();
    }
}
