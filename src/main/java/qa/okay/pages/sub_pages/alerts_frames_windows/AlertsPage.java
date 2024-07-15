package qa.okay.pages.sub_pages.alerts_frames_windows;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.utils.Waits;

public class AlertsPage extends BaseElement {

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement timerAlertButton;

    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement promptButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;

    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Getting 'Alert' element step")
    public Alert getAlert() {
        Waits.waitPageLoading(driver);
        alertButton.click();
        return Waits.waitForAlertToBeDisplayed(driver);
    }

    @Step(value = "Getting 'Alert with delay' element step")
    public Alert getTimerAlert() {
        Waits.waitPageLoading(driver);
        timerAlertButton.click();
        return Waits.waitForAlertToBeDisplayed(driver);
    }

    @Step(value = "Getting 'Alert Confirm' element step")
    public Alert getConfirm() {
        Waits.waitPageLoading(driver);
        confirmButton.click();
        return Waits.waitForAlertToBeDisplayed(driver);
    }

    @Step(value = "Getting 'Alert Prompt' element step")
    public Alert getPrompt(String message) {
        Waits.waitPageLoading(driver);
        promptButton.click();
        Alert alert = Waits.waitForAlertToBeDisplayed(driver);
        alert.sendKeys(message);
        return alert;
    }

    @Step(value = "Accepting Alert step")
    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    @Step(value = "Dismissing Alert step")
    public void dismissAlert(Alert alert) {
        alert.dismiss();
    }

    @Step(value = "Getting Confirm message step")
    public String getConfirmResult() {
        return confirmResult.getText();
    }

    @Step(value = "Getting Prompt message step")
    public String getPromptResult() {
        return promptResult.getText();
    }
}
