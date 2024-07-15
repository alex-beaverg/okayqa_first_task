package qa.okay.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;

import java.util.List;

public class ModalResultTable extends BaseElement {

    @FindBy(xpath = "//div[@class='table-responsive']//tbody/tr/td[2]")
    private List<WebElement> results;

    public ModalResultTable(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Getting Practice Form result table step")
    public List<WebElement> getResults() {
        return results;
    }
}
