package qa.okay.pages.sub_pages.interactions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.utils.Waits;

public class DroppablePage extends BaseElement {
    private final Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement dragMeElement;

    @FindBy(xpath = "//div[@id='draggable']/following-sibling::div[@id='droppable']")
    private WebElement dropHereElement;

    @FindBy(xpath = "//div[@id='draggable']/following-sibling::div[@id='droppable']/p")
    private WebElement dropHereElementText;

    private final By droppedTextLocator = By.xpath("//div[@id='draggable']/following-sibling::div[@id='droppable']/p[contains(text(), 'Dropped!')]");

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Dragging and dropping element step")
    public void dragAndDropElement() {
        Waits.waitPageLoading(driver);
        actions.dragAndDrop(dragMeElement, dropHereElement)
                .perform();
    }

    @Step(value = "Getting text from 'Drop Here' element step")
    public String getTextFromDropHere() {
        Waits.waitForLocatorToBePresent(driver, droppedTextLocator);
        return dropHereElementText.getText();
    }
}
