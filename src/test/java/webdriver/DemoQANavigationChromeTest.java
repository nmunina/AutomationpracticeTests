package webdriver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQANavigationChromeTest extends AbstractChromeWebDriverTest {
    String navigationUrl = "https://demoqa.com/";

    @Test
    public void navigationForwardBackward() {

        String expectedTag = "textarea";
        driver.navigate().to(navigationUrl);
        sleep(5);

        driver.findElement(By.linkText("Sortable")).click();
        driver.findElement(By.linkText("HTML contact form")).click();
        driver.navigate().back();
        driver.navigate().forward();
        String realTag = driver.findElement(By.id("subject")).getTagName();
        Assert.assertEquals(expectedTag, realTag, "failed");
        driver.navigate().refresh(); // like F5
    }

    //WebElement Commands
    // void clear( ) – This method will clear the value of any text type element.
    @Test
    public void webElementClear() {
    driver.get("https://demoqa.com/html-contact-form/");
    sleep(5);

    driver.findElement(By.id("lname")).clear();
    }

    //sendKeys(CharSequence… keysToSend ) – This method types in the values passed in the argument into the associated web element object.
    @Test
    public void webElementSendKeys() {
        driver.get("https://demoqa.com/html-contact-form/");
        driver.findElement(By.className("firstname")).sendKeys("First Name");
        driver.findElement(By.id("lname")).sendKeys("Testing LastName");
        driver.findElement(By.name("country")).sendKeys("My country");
        driver.findElement(By.id("subject")).sendKeys("A lot od text can be written here");
    }

    // isDisplayed( ) – This method checks the visibility of a web element. (boolean)
    @Test
    public void webElementIsDisplayd() {
        driver.get("https://demoqa.com/sortable/");
        sleep(5);

        boolean isDisplayd = driver.findElement(By.id("sortable")).isDisplayed();
        System.out.println(isDisplayd);
    }

    // isEnabled( ) – This method return true/false depending on the state of the element
    @Test
    public void webElementIsEnabled() {
        driver.get("https://demoqa.com/selectable/");
        sleep(5);

        /*boolean isEnabled = driver.findElement(By.id("selectable")).isEnabled();
        boolean isSelected = driver.findElement(By.name("Item 2")).isSelected();
        System.out.println("Is enabled - " + isEnabled + ". Is selected - " + isSelected);*/

        driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div[2]/div[2]/ol/li[1]")).click();
    }

    @Test
    public void navegateToBack() {
        driver.navigate().to("https://demoqa.com/checkboxradio/");
        driver.navigate().to("https://demoqa.com/");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();
    }

}
