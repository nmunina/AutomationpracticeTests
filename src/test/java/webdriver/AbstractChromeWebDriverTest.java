package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractChromeWebDriverTest {

	protected WebDriver driver;

	public AbstractChromeWebDriverTest() {
		super();
	}

	@BeforeTest
	public void beforeTest() {
		//Download the web driver executable
		WebDriverManager.chromedriver().setup();
		
		//Create a instance of your web driver - chrome
		driver = new ChromeDriver();

		// launch browser and direct it to the  URL
		//driver.get("");
		/* It's used to go to the particular website ,
		But it doesn't maintain the browser History and cookies so ,
		we can't use forward and backward button , i
		f we click on that , page will not get schedule */

		//driver.navigate();
		/*
		it's used to go to the particular website , but
		it maintains the browser history and cookies, so
		we can use forward and backward button to navigate between the pages during the coding of Testcase
		*/

	}

	@AfterTest
	public void afterTest() {
		// ways to stop
		// driver.close(); //close browser
		// system.exit(0); //whole Java program will end while leaving the browser window open

		driver.quit();
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}