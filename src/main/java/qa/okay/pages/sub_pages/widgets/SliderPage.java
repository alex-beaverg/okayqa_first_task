package qa.okay.pages.sub_pages.widgets;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;

public class SliderPage extends BaseElement {
    private final Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[@id='sliderContainer']//span/input")
    private WebElement slider;

    @FindBy(xpath = "//input[@id='sliderValue']")
    private WebElement sliderValue;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Moving Slider to max position step")
    public void moveSliderToMax() {
        actions.clickAndHold(slider)
                .moveByOffset(500, 0)
                .release()
                .perform();
    }

    @Step(value = "Moving Slider to min position step")
    public void moveSliderToMin() {
        actions.clickAndHold(slider)
                .moveByOffset(-500, 0)
                .release()
                .perform();
    }

    @Step(value = "Getting Slider value from text input step")
    public String getSliderValue() {
        return sliderValue.getAttribute("value");
    }
}
