package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;

public class AutomationpracticeFireFoxTests extends AbstractMultiBrowser {

    // base variables
    String expectedPageTitle = "My Store";
    String actualPageTitle = "";
    String  baseUrl = "http://automationpractice.com/index.php";

    // tagName[attribute=attributeName]
    //("input[id=email]")

    //By.cssSelector(“div[class=’_1vC4OE _2rQ-NK’]”);
    //By.cssSelector(“div._1vC4OE._2rQ-NK”);
    //By.xpath(“//div[@class=’_1vC4OE _2rQ-NK’]”);
    //div#someId .aClass.andAnother input[type=text]
    //input[name=Sex][value=M]   for <input type="radio" name="Sex" value="F" />
    @Test (enabled = false)
    public void sccFromStaffan() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement header = driver.findElement(By.cssSelector("img[class=img-responsive]"));
        wait.until(ExpectedConditions.visibilityOf(header)).click();
    }

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

    @Test
    public void selectDropdown(){
        driver.get("https://demoqa.com/selectmenu/");

        Select drpSpeed = new Select(driver.findElement(By.id("speed-button")));
        drpSpeed.selectByVisibleText("Fast");
        sleep(2);
        drpSpeed.selectByIndex(2);
        sleep(2);
        drpSpeed.deselectAll();
        sleep(2);

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
