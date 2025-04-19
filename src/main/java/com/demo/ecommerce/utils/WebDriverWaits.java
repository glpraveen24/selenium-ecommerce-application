package com.demo.ecommerce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebDriverWaits {

    private WebDriver driver;
    private static final long DEFAULT_TIMEOUT = 10;
    private static final long DEFAULT_POLLING_INTERVAL = 500;

    public WebDriverWaits(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits for the visibility of a specific WebElement.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement if it becomes visible within the timeout, otherwise null.
     */
    public WebElement waitForVisibilityOfElement(WebElement element) {
        return waitForVisibilityOfElement(element, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for the visibility of a specific WebElement with a custom timeout.
     *
     * @param element The WebElement to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return The WebElement if it becomes visible within the timeout, otherwise null.
     */
    public WebElement waitForVisibilityOfElement(WebElement element, long timeoutInSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class);
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.err.println("WebElement not visible within the specified timeout: " + element);
            return null;
        }
    }

    /**
     * Waits for the invisibility of a specific WebElement.
     *
     * @param element The WebElement to wait for.
     * @return True if the WebElement becomes invisible within the timeout, otherwise false.
     */
    public boolean waitForInvisibilityOfElement(WebElement element) {
        return waitForInvisibilityOfElement(element, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for the invisibility of a specific WebElement with a custom timeout.
     *
     * @param element The WebElement to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return True if the WebElement becomes invisible within the timeout, otherwise false.
     */
    public boolean waitForInvisibilityOfElement(WebElement element, long timeoutInSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class);
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.err.println("WebElement did not become invisible within the specified timeout: " + element);
            return false;
        }
    }

    /**
     * Waits for a specific WebElement to be clickable.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement if it becomes clickable within the timeout, otherwise null.
     */
    public WebElement waitForElementToBeClickable(WebElement element) {
        return waitForElementToBeClickable(element, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for a specific WebElement to be clickable with a custom timeout.
     *
     * @param element The WebElement to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return The WebElement if it becomes clickable within the timeout, otherwise null.
     */
    public WebElement waitForElementToBeClickable(WebElement element, long timeoutInSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.err.println("WebElement not clickable within the specified timeout: " + element);
            return null;
        }
    }

    /**
     * Waits for the presence of a specific WebElement.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement if it is present within the timeout, otherwise null.
     */
    public WebElement waitForPresenceOfElement(By locator) {
        return waitForPresenceOfElement(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for the presence of a specific WebElement with a custom timeout.
     *
     * @param locator The By locator of the WebElement to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return The WebElement if it is present within the timeout, otherwise null.
     */
    public WebElement waitForPresenceOfElement(By locator, long timeoutInSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.err.println("WebElement not present within the specified timeout: " + locator);
            return null;
        }
    }

    /**
     * Waits for the visibility of all WebElements within a list.
     *
     * @param elements The List of WebElements to wait for.
     * @return The List of WebElements if all are visible within the timeout, otherwise null.
     */
    public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements) {
        return waitForVisibilityOfAllElements(elements, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for the visibility of all WebElements within a list with a custom timeout.
     *
     * @param elements The List of WebElements to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return The List of WebElements if all are visible within the timeout, otherwise null.
     */
    public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements, long timeoutInSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                    .ignoring(NoSuchElementException.class);
            return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            System.err.println("Not all WebElements in the list became visible within the specified timeout: " + elements);
            return null;
        }
    }

    /**
     * Implicitly waits for a specified duration. It's generally recommended to use explicit waits.
     *
     * @param timeoutInSeconds The duration to wait in seconds.
     */
    public void setImplicitWait(long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }

    /**
     * Resets the implicit wait to 0.
     */
    public void resetImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}