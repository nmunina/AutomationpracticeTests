package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoQASelectChrome extends AbstractChromeWebDriverTest {

    @Test
    public void selectDropdown(){
        driver.get("https://demoqa.com/selectmenu/");
        sleep(2);
        driver.findElement(By.id("speed-button")).click();
        sleep(1);
        Select drpSpeed = new Select(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-button")));
        sleep(1);
        drpSpeed.selectByVisibleText("Fast");
        sleep(2);
        drpSpeed.selectByIndex(2);
        sleep(2);
        drpSpeed.deselectAll();
        sleep(2);

    }
}
