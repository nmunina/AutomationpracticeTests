package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

//Implicit Wait. Waiting for the time
//Explicit Wait. Waiting for condition
    //    alertIsPresent()
    //    elementSelectionStateToBe()
    //    elementToBeClickable()
    //    elementToBeSelected()
    //    frameToBeAvaliableAndSwitchToIt()
    //    invisibilityOfTheElementLocated()
    //    invisibilityOfElementWithText()
    //    presenceOfAllElementsLocatedBy()
    //    presenceOfElementLocated()
    //    textToBePresentInElement()
    //    textToBePresentInElementLocated()
    //    textToBePresentInElementValue()
    //    titleIs()
    //    titleContains()
    //    visibilityOf()
    //    visibilityOfAllElements()
    //    visibilityOfAllElementsLocatedBy()
    //    visibilityOfElementLocated()


public class DemoQAWaitChrome extends AbstractChromeWebDriverTest {
    //Explicit wait-metod
    //För att få en renare kod kan vi skapa en metod som gör de olika wait-funktionerna vi behöver
    //click(driver, By.cssSelector("cssSelector"));
    public static void click(WebDriver driver, By by) {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.
                elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //Implicit wait (används sällan)
    //Används när vi vill vänta en specifik tid



    //Fluent wait
    //Med fluent wait kan vi bestämma mycket noggrannare hur vi vill använda wait

    // Waiting 30 seconds for an element to be present on the page,
    // checking for its presence once every 5 seconds.


    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(By.id("elementId"));
        }
    });

//Explicit wait
//Används när vi vill vänta på att en händelse ska inträffa

//inträffa    WebElement element =
//    (new WebDriverWait(driver, 10)).until(ExpectedConditions.
//    presenceOfElementLocated(By.id("elementId")));

    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    @Test
    public void implicitWait() {
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        driver.findElement(By.linkText("Keyboard Events")).click();
    }

    @Test
    public void explicitWait() {
        driver.get("https://demoqa.com/");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // waiting for the element is visible
        WebElement testLink;
        testLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Spinner")));
        testLink.click();
    }

    @Test // Fluent Wait is used to tell the web driver to wait for a condition, as well as the frequency
    public  void fluentWait() {
        driver.get("https://demoqa.com/");
        //Wait wait = new FluentWait(WebDriver reference)
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);

        Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);


        WebElement clickseleniumlink = wait.until(driver -> driver.findElement(By.linkText("Spinner")));
        //click on the selenium link
        clickseleniumlink.click();

    }
}
