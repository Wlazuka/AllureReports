package allureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Wait;

public class BaseTest {

    WebDriver driver;
    Wait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new Wait(this.driver);
        driver.get("https://opensource-demo.orangehrmlive.com/lang=eng");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
