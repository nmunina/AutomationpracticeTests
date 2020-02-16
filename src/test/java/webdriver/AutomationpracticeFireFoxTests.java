package webdriver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationpracticeFireFoxTests extends AbstractFireFoxWebDriverTest {

    // base variables
    String expectedPageTitle = "My Store";
    String actualPageTitle = "";

    // test "get page title and compare"
    @Test
    public void pageTitle() {
        actualPageTitle = driver.getTitle();

        if (actualPageTitle.equals(expectedPageTitle)) System.out.println("Test Passed!");
        else System.out.println("Test Failed");
    }

    // find element by
    // ByID
    @Test
    public void findByID() {

        String tagName = driver.findElement(By.id("header_logo")).getTagName();
        System.out.println(tagName);
    }

    //ByName
    @Test
    public void getByName() {

        String tagName = driver.findElement(By.name("search_query")).getTagName();
        System.out.println(tagName);
    }

    //By.cssSelector
   @Test
    public void getByCssSelector() {

        String tagName = driver.findElement(By.cssSelector("#block_top_menu li:nth-child(1)")).getTagName();
        System.out.println(tagName);
    }

    //By.linkText
    @Test
    public void getByLinkText() {

        String tagName = driver.findElement(By.linkText("Sign in")).getTagName();
        System.out.println(tagName);
    }
    //By.partialLinkText
    @Test
    public void getByPartialLinkText() {

        String tagName = driver.findElement(By.partialLinkText("Contact")).getText();
        System.out.println(tagName);
    }

    //By.className
    @Test
    public void getByClassName () {

        String tagName = driver.findElement(By.className("shop-phone")).getText();
        System.out.println(tagName);
    }

    //By.tagName
    @Test
    public void getByTagName () {

        String tagName = driver.findElement(By.tagName("input")).getText();
        System.out.println(tagName);
    }

    //By.xpath  |   | findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/ tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/ form/table/tbody/tr[5]"))  |
    //it is slow as compared to CSS.
    //It’s browser dependent, and there are differences in IE vs. Firefox XPath implementations.
    @Test
    public void getByXpath() {

        String tagName = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[1]/a/img")).getTagName();
        System.out.println(tagName);
    }

    // isEnabled( ) – This method return true/false depending on the state of the element
    @Test
    public void webElementIsEnabled() {
        driver.get("https://demoqa.com/checkboxradio/");
        boolean isSelected = driver.findElement(By.name("radio-1")).isSelected();
        System.out.println(isSelected);
       // driver.findElement(By.name("radio-1")).click();
        System.out.println(". Is selected - " + isSelected);
        driver.findElement(By.id("radio-2")).click();
    }


}
