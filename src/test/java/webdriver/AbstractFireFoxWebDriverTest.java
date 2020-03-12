package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        //Create a instance of your web driver - firefox
        driver = new FirefoxDriver();
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
