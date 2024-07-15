package qa.okay.pages.main_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.pages.sub_pages.interactions.DroppablePage;

public class InteractionsPage extends BaseElement {

    @FindBy(xpath = "//div[@class='element-group'][5]//li[@id='item-3']")
    private WebElement droppableItem;

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking Sub menu 'Droppable' item step")
    public DroppablePage clickDroppableItem() {
        droppableItem.click();
        return new DroppablePage(driver);
    }
}
