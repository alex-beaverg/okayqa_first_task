package qa.okay.pages.main_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.pages.sub_pages.widgets.ProgressBarPage;
import qa.okay.pages.sub_pages.widgets.SliderPage;

public class WidgetsPage extends BaseElement {

    @FindBy(xpath = "//div[@class='element-group'][4]//li[@id='item-3']")
    private WebElement sliderItem;

    @FindBy(xpath = "//div[@class='element-group'][4]//li[@id='item-4']")
    private WebElement progressBarItem;

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Clicking Sub menu 'Slider' item step")
    public SliderPage clickSliderItem() {
        sliderItem.click();
        return new SliderPage(driver);
    }

    @Step(value = "Clicking Sub menu 'Progress Bar' item step")
    public ProgressBarPage clickProgressBarItem() {
        progressBarItem.click();
        return new ProgressBarPage(driver);
    }
}
