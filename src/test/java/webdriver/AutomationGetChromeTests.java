package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AutomationGetChromeTests extends AbstractChromeWebDriverTest {

    // declaration and instantiation of objects/variables
    String baseUrl = "http://automationpractice.com/index.php";
    String expectedTitle = "My Store";
    String actualTitle = "";

    // fetch Mercury Tours' homepage
    // verify its title
    // print out the result of the comparison
    @Test
    public void pageTitle() {
        // launch Chrome fox and direct it to the Base URL
        driver.get(baseUrl);
        sleep(5);

        // get the actual page title
        actualTitle = driver.getTitle();

        // compare the actual and the expected title and print out passed or failed
        // if (actualTitle.equals(expectedTitle)) System.out.println("Test Passed!");
        // else System.out.println("Test Failed");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title does not match expected");
    }

    // actions
    @Test// (dependsOnMethods = {"pageTitle"})
    public void actionsClick() {
        driver.get(baseUrl);
        sleep(5);

        // click
        /*
        It does not take any parameter/argument.
        The method automatically waits for a new page to load if applicable.
        The element to be clicked-on, must be visible
         */
        driver.findElement(By.name("submit_search")).click(); }

    @Test // getTitle - Fetches the title of the current page
    public void getTitle() {
        driver.get(baseUrl);
        sleep(5);

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Reporter.log(pageTitle);
    }

    @Test // getPageSource() - Returns the source code of the page as a String value
    public void getPageSource() {
        driver.get(baseUrl);
        sleep(5);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        Reporter.log(pageSource);
    }

    @Test // getCurrentUrl() - Fetches the string representing the current URL that the browser is looking at
    public void getUrl() {
        driver.get(baseUrl);
        sleep(5);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Reporter.getOutput().add("getOutput");
    }

    @Test // getText() - Fetches the inner text of the element that you specify
    public void getElementText() {
        driver.get(baseUrl);
        sleep(5);

        String getText = driver.findElement(By.id("home-page-tabs")).getText();
        System.out.println(getText);
        Reporter.log(getText, true);
    }

    @Test
    public void  printAttributes() {
        driver.get("http://automationpractice.com/index.php");
        WebElement header = driver.findElement(By.id("homepage-slider"));
        //header.sendKeys("my own text input");
        System.out.println("tagName: " + header.getTagName());
        System.out.println("location: " + header.getLocation());
        System.out.println("attribute title: " + header.getAttribute("title"));
        System.out.println("attribute class: " + header.getAttribute("class"));
        System.out.println("webElement: " + header);
        System.out.println("gettext: " + header.getText());
        System.out.println("getRect: " + header.getRect());
        System.out.println("getClass: " + header.getClass());
        System.out.println("getCssValue: " + header.getCssValue("container"));

    }
}
