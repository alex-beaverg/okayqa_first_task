package qa.okay.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.pages.main_pages.AlertsWindowsPage;
import qa.okay.pages.main_pages.FormsPage;
import qa.okay.pages.main_pages.InteractionsPage;
import qa.okay.pages.main_pages.WidgetsPage;

public class ComponentMainMenu extends BaseElement {

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][2]")
    private WebElement formsItem;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][3]")
    private WebElement alertsWindowsItem;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][4]")
    private WebElement widgetsItem;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][5]")
    private WebElement interactionsItem;

    public ComponentMainMenu(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking Main menu 'Forms' item step")
    public FormsPage clickFormsItem() {
        formsItem.click();
        return new FormsPage(driver);
    }

    @Step(value = "Clicking Main menu 'Alerts, Frames & Windows' item step")
    public AlertsWindowsPage clickAlertsWindowsItem() {
        alertsWindowsItem.click();
        return new AlertsWindowsPage(driver);
    }

    @Step(value = "Clicking Main menu 'Widgets' item step")
    public WidgetsPage clickWidgetsItem() {
        widgetsItem.click();
        return new WidgetsPage(driver);
    }

    @Step(value = "Clicking Main menu 'Interactions' item step")
    public InteractionsPage clickInteractionsItem() {
        interactionsItem.click();
        return new InteractionsPage(driver);
    }
}
