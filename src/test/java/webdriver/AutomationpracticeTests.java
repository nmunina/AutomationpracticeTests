package webdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AutomationpracticeTests extends AbstractChromeWebDriverTest {

    @Test
    public void testWomanTshirt() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("T-shirts")).click();

    }
}
