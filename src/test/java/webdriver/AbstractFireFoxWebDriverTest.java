package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractFireFoxWebDriverTest {

    protected WebDriver driver;

    public AbstractFireFoxWebDriverTest() {
        super();
    }

    @BeforeTest
    public void beforeTest() {
        //Download the latest web driver executable
        WebDriverManager.firefoxdriver().setup();

        //Create a instance of your web driver - chrome
        //String  baseUrl = "http://automationpractice.com/index.php";
        driver = new FirefoxDriver();
        //driver.get(baseUrl);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
