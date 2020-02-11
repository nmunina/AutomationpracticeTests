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
}
