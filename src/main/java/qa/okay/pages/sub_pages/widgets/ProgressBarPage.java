package qa.okay.pages.sub_pages.widgets;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.utils.Waits;

public class ProgressBarPage extends BaseElement {
    private final By progressBarMinLocator = By.xpath("//div[@role='progressbar'][contains(@aria-valuenow, '0')]");
    private final By progressBarMaxLocator = By.xpath("//div[@role='progressbar'][contains(@aria-valuenow, '100')]");

    @FindBy(xpath = "//button[@id='startStopButton']")
    private WebElement startStopButton;

    @FindBy(xpath = "//button[@id='resetButton']")
    private WebElement resetButton;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking 'Start progress bar' button step")
    public void clickStartStopButton() {
        startStopButton.click();
    }

    @Step(value = "Clicking 'Reset progress bar' button step")
    public void clickResetButton() {
        resetButton.click();
    }

    @Step(value = "Checking completing of Progress Bar action step")
    public boolean isProgressBarComplete() {
        return Waits.waitForLocatorToBePresent(driver, progressBarMaxLocator);
    }

    @Step(value = "Checking reset of Progress Bar action step")
    public boolean isProgressBarReset() {
        return Waits.waitForLocatorToBePresent(driver, progressBarMinLocator);
    }
}
