package qa.okay.pages.main_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.pages.sub_pages.forms.PracticeFormPage;

public class FormsPage extends BaseElement {

    @FindBy(xpath = "//div[@class='element-group'][2]//li[@id='item-0']")
    private WebElement practiceFormItem;

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking Sub menu 'Practice Form' item step")
    public PracticeFormPage clickPracticeFormItem() {
        practiceFormItem.click();
        return new PracticeFormPage(driver);
    }
}
