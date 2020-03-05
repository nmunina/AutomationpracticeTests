package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class AbstractChromeWebDriverTest {

	protected WebDriver driver;

	public AbstractChromeWebDriverTest() {
		super();
	}

	@Parameters("browser")

	@BeforeTest
	// Passing Browser parameter from TestNG xml
	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("http://automationpractice.com/index.php");
			// If browser is IE, then do this
	//	}else if (browser.equalsIgnoreCase("ie")) {
	//		// Here I am setting up the path for my IEDriver
	//		System.setProperty("webdriver.ie.driver", "D:\ToolsQA\OnlineStore\drivers\IEDriverServer.exe");
	//		driver = new InternetExplorerDriver();
		}


		// Doesn't the browser type, lauch the Website

	//Download the web driver executable
		//WebDriverManager.chromedriver().setup();

		//specified version for Chrome driver
		WebDriverManager.chromedriver().version("80.0.3987.106").setup();
		
		//Create a instance of your web driver - chrome
		driver = new ChromeDriver();

		// launch browser and direct it to the  URL
		//driver.get("");
		/* It's used to go to the particular website ,
		But it doesn't maintain the browser History and cookies so we can't use forward and backward button , if we click on that , page will not get schedule */

		//driver.navigate();
		/*
		it's used to go to the particular website , but it maintains the browser history and cookies, so we can use forward and backward button to navigate between the pages during the coding of Testcase
		*/

	}

	@AfterTest
	public void afterTest() {
		// ways to stop
		// driver.close(); //close browser
		// system.exit(0); //whole Java program will end while leaving the browser window open

		driver.quit();
	}

	/* public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

	protected void sleep(int i) {

		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}