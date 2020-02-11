package webdriver;

import org.testng.annotations.Test;

public class AutomationpracticeFireFoxTests extends AbstractFireFoxWebDriverTest {
    // base variables

    String baseUrl = "http://automationpractice.com/index.php";
    String expectedPageTitle = "My Store";
    String actualPageTitle = "";

    // test "get page title and compare"
    @Test
    public void pageTitle() {
        driver.get(baseUrl);
        actualPageTitle = driver.getTitle();

        if (actualPageTitle.equals(expectedPageTitle)) System.out.println("Test Passed!");
        else System.out.println("Test Failed");
    }

}
