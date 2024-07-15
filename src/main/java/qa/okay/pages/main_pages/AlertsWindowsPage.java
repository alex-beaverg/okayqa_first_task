package qa.okay.pages.main_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.pages.sub_pages.alerts_frames_windows.AlertsPage;
import qa.okay.pages.sub_pages.alerts_frames_windows.FramesPage;

public class AlertsWindowsPage extends BaseElement {

    @FindBy(xpath = "//div[@class='element-group'][3]//li[@id='item-1']")
    private WebElement alertsItem;

    @FindBy(xpath = "//div[@class='element-group'][3]//li[@id='item-2']")
    private WebElement framesItem;

    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking Sub menu 'Alerts' item step")
    public AlertsPage clickAlertsItem() {
        alertsItem.click();
        return new AlertsPage(driver);
    }

    @Step(value = "Clicking Sub menu 'Frames' item step")
    public FramesPage clickFramesItem() {
        framesItem.click();
        return new FramesPage(driver);
    }
}
