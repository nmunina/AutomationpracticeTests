package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class AbstractMultiBrowser {

    public WebDriver driver;

//    public MultiBrowser() {}
    @Parameters("browser")
    @BeforeTest
    // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser) {

        // If the browser is Firefox, then do this
        if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {

        //Download the web driver executable
        //WebDriverManager.chromedriver().setup();

        //specified version for Chrome driver
        WebDriverManager.chromedriver().version("80.0.3987.106").setup();
        driver = new ChromeDriver();
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


    protected void sleep(int i) {

        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
