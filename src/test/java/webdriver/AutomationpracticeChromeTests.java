package webdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AutomationpracticeChromeTests extends AbstractChromeWebDriverTest {

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

        // get the actual page title
        actualTitle= driver.getTitle();

        // compare the actual and the expected title and print out passed or failed
        if (actualTitle.equals(expectedTitle)) System.out.println("Test Passed!");
        else System.out.println("Test Failed");
    }

    // find element by
    @Test
    public void findByID() {
        driver.get(baseUrl);

        //find element by id
        String tagName = driver.findElement(By.id("header_logo")).getTagName();
        System.out.println(tagName);
    }

    // actions
    @Test
    public void actionsClick() {
        driver.get(baseUrl);

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

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @Test // getPageSource() - Returns the source code of the page as a String value
    public void getPageSource() {
        driver.get(baseUrl);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @Test // getCurrentUrl() - Fetches the string representing the current URL that the browser is looking at
    public void getUrl() {
        driver.get(baseUrl);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    @Test // getText() - Fetches the inner text of the element that you specify
    public void getElementText() {
        driver.get(baseUrl);

        String getText = driver.findElement(By.id("home-page-tabs")).getText();
        System.out.println(getText);
    }

}
