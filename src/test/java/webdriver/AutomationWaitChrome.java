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
import java.util.concurrent.TimeUnit;

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


public class AutomationWaitChrome extends AbstractChromeWebDriverTest {

    @Test
    public void implicitWait() {
        driver.get("https://demoqa.com/");

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        WebElement clickseleniumlink = wait.until(driver -> driver.findElement(By.linkText("Spinner")));

        //click on the selenium link
        clickseleniumlink.click();

    }
}
