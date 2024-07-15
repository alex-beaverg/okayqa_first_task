package qa.okay.pages.sub_pages.alerts_frames_windows;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;

public class FramesPage extends BaseElement {
    private final String windowHandle;

    @FindBy(xpath = "//iframe[@id='frame1']")
    private WebElement frame1;

    @FindBy(xpath = "//iframe[@id='frame2']")
    private WebElement frame2;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    private WebElement frameHeader;

    public FramesPage(WebDriver driver) {
        super(driver);
        windowHandle = driver.getWindowHandle();
    }

    @Step(value = "Getting text from first frame step")
    public String getHeaderFromFirstFrame() {
        driver.switchTo().window(windowHandle);
        driver.switchTo().frame(frame1);
        return frameHeader.getText();
    }

    @Step(value = "Getting text from second frame step")
    public String getHeaderFromSecondFrame() {
        driver.switchTo().window(windowHandle);
        driver.switchTo().frame(frame2);
        return frameHeader.getText();
    }
}
