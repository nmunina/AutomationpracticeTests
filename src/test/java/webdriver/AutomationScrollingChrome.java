package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AutomationScrollingChrome extends AbstractChromeWebDriverTest {

    // https://www.guru99.com/scroll-up-down-selenium-webdriver.html
    //To scroll down the web page by pixel.
    //To scroll down the web page by the visibility of the element.
    //To scroll down the web page at the bottom of the page.
    //Horizontal scroll on the web page.

    @Test
    public void scrollDown() {
        // JavaScriptExecutor interface that helps to execute JavaScript methods through Selenium Webdriver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/sortable/");
        driver.manage().window().maximize();

        // This  will scroll down the page by  1000 pixel vertical
        // executeScript("window.scrollBy(x-pixels,y-pixels)");
        //x-pixels is the number at x-axis, it moves to the left if number is positive and it move to the right if number is negative .
        //y-pixels is the number at y-axis, it moves to the down if number is positive and it move to the up if number is in negative .
        js.executeScript("window.scrollBy(0,800)");
        sleep(2);

        //scroll up
        js.executeScript("window.scrollBy(0,-300)");
        sleep(2);
    }

    @Test
    public void scrollVisible() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/sortable/");
        driver.manage().window().maximize();

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Button"));

        //This will scroll the page till the element is found
        //"arguments[0]" means first index of page starting at 0.
        //works for horisontal allso
        js.executeScript("arguments[0].scrollIntoView();", Element);
        sleep(2);

        // Scroll upp
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Sortable")));
        sleep(2);
    }

    @Test
    public void scrollBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/sortable/");

        // scroll to bottom
        //"document.body.scrollHeight" returns the complete height of the body i.e web page.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(2);
    }
}
