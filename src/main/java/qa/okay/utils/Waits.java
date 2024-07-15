package qa.okay.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final Duration DURATION = Duration.ofSeconds(15);

    @Step(value = "Waiting for Alert to be displayed sub-step")
    public static Alert waitForAlertToBeDisplayed(WebDriver driver) {
        return (new WebDriverWait(driver, DURATION)).until(ExpectedConditions.alertIsPresent());
    }

    @Step(value = "Waiting for locator to be present sub-step")
    public static boolean waitForLocatorToBePresent(WebDriver driver, By locator) {
        try {
            (new WebDriverWait(driver, DURATION)).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    @Step(value = "Waiting for page loading sub-step")
    public static void waitPageLoading(WebDriver driver) {
        (new WebDriverWait(driver, DURATION))
                .until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
