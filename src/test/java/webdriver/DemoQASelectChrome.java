package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

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
    @Test
    public void multipleSelection(){
        driver.get("https://demoqa.com/selectable/");

        // Here, the code below will select all rows matching the given XPath.
        List<WebElement> rows = driver.findElements(By.cssSelector(".ui-selectee"));

        // print the total number of elements
        System.out.println("Total selected rows are " + rows.size());

        // Now using Iterator we will iterate all elements
        Iterator<WebElement> iter = rows.iterator();

        // this will check whether list has some element or not
        while (iter.hasNext()) {

            // Iterate one by one
            WebElement item = iter.next();

            // get the text
            String label = item.getText();

            // print the text
            System.out.println("Row label is " + label);
        }
    }

    // isEnabled( ) – This method return true/false depending on the state of the element
    @Test
    public void webElementIsEnabled() {
        driver.get("https://demoqa.com/checkboxradio/");
        sleep(2);
        boolean isSelected = driver.findElement(By.name("radio-1")).isSelected();
        System.out.println(isSelected);
        // driver.findElement(By.name("radio-1")).click();
        System.out.println(". Is selected - " + isSelected);
        driver.findElement(By.id("radio-2")).click();
    }
}
