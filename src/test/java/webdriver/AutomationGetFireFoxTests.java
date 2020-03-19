package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;

public class AutomationGetFireFoxTests extends AbstractFireFoxWebDriverTest {

    // base variables
    String expectedPageTitle = "My Store";
    String actualPageTitle = "";
    String automationPracticeURL = "http://automationpractice.com/index.php";

    // tagName[attribute=attributeName]
    //("input[id=email]")

    //By.cssSelector(“div[class=’_1vC4OE _2rQ-NK’]”);
    //By.cssSelector(“div._1vC4OE._2rQ-NK”);
    //By.xpath(“//div[@class=’_1vC4OE _2rQ-NK’]”);
    //div#someId .aClass.andAnother input[type=text]
    //input[name=Sex][value=M]   for <input type="radio" name="Sex" value="F" />
    @Test (enabled = false)
    public void sccFromStaffan() {
        driver.get(automationPracticeURL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement header = driver.findElement(By.cssSelector("img[class=img-responsive]"));
        wait.until(ExpectedConditions.visibilityOf(header)).click();
    }

    // test "get page title and compare"
    @Test
    public void pageTitle() {
        driver.get(automationPracticeURL);

        actualPageTitle = driver.getTitle();

        if (actualPageTitle.equals(expectedPageTitle)) System.out.println("Test Passed!");
        else System.out.println("Test Failed");
    }

    // find element by
    // ByID
    @Test
    public void findByID() {

        driver.get(automationPracticeURL);

        String tagName = driver.findElement(By.id("header_logo")).getTagName();
        System.out.println(tagName);
    }

    //ByName
    @Test
    public void getByName() {

        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.name("search_query")).getTagName();
        System.out.println(tagName);
    }

    //By.cssSelector
   @Test
    public void getByCssSelector() {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.cssSelector("#block_top_menu li:nth-child(1)")).getTagName();
        System.out.println(tagName);
    }

    //By.linkText
    @Test
    public void getByLinkText() {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.linkText("Sign in")).getTagName();
        System.out.println(tagName);
    }

    //By.partialLinkText
    @Test
    public void getByPartialLinkText() {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.partialLinkText("Contact")).getText();
        System.out.println(tagName);
    }

    //By.className
    @Test
    public void getByClassName () {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.className("shop-phone")).getText();
        System.out.println(tagName);
    }

    //By.tagName
    @Test
    public void getByTagName () {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.tagName("input")).getText();
        System.out.println(tagName);
    }

    //By.xpath  |   | findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/ tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/ form/table/tbody/tr[5]"))  |
    //it is slow as compared to CSS.
    //It’s browser dependent, and there are differences in IE vs. Firefox XPath implementations.
    @Test
    public void getByXpath() {
        driver.get(automationPracticeURL);
        String tagName = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[1]/a/img")).getTagName();
        System.out.println(tagName);
    }
}
