package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AbstractChromeWebDriverTest {
	protected WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;

	@BeforeMethod
	// Passing Browser parameter from TestNG xml
	public void setUp(){

		//Download the web driver executable
		//WebDriverManager.chromedriver().setup();

		//specified version for Chrome driver
		WebDriverManager.chromedriver().version("80.0.3987.106").setup();

		//Create a instance of your web driver - chrome
		driver = new ChromeDriver();

		//driver.get("");
		/* It's used to go to the particular website ,
		But it doesn't maintain the browser History and cookies so we can't use forward and backward button ,
		if we click on that , page will not get schedule
		*/

			//driver.navigate();
		/*
		it's used to go to the particular website , but it maintains the browser history and cookies, so we can use forward and backward button to navigate between the pages during the coding of Testcase
		*/

		wait = new WebDriverWait(driver, 20);

		// JavaScriptExecutor interface that helps to execute JavaScript methods through Selenium Webdriver
		js = (JavascriptExecutor) driver;
	}

	@AfterMethod
	public void afterTest () {
		// ways to stop
		// driver.close(); //close browser
		// system.exit(0); //whole Java program will end while leaving the browser window open
		driver.quit();
	}

	protected void sleep ( int i){
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}