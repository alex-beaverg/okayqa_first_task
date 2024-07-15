package qa.okay.base;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseElement {
    protected final WebDriver driver;

    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']")
    private WebElement mainPagesText;

    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']//h1")
    private WebElement subPagesTitle;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step(value = "Checking opening current Main Page step")
    public boolean isMainPageOpen(String text) {
        return mainPagesText.getText().equals(text);
    }

    @Step(value = "Checking opening current Sub Page step")
    public boolean isSubPageOpen(String title) {
        return subPagesTitle.getText().equals(title);
    }

    @Step(value = "Scrolling page")
    protected void scrollPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");
    }
}
