package qa.okay.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import qa.okay.base.BaseElement;
import qa.okay.components.ComponentMainMenu;
import qa.okay.utils.PropertyGetter;

public class HomePage extends BaseElement {
    private final String home_url;
    private final ComponentMainMenu mainMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        home_url = PropertyGetter.getProperty("home_url");
        this.driver.get(home_url);
        mainMenu = new ComponentMainMenu(driver);
    }

    @Step(value = "Checking opening Home Page step")
    public boolean isHomePageOpen() {
        return home_url.equals(driver.getCurrentUrl());
    }

    @Step(value = "Getting Main Menu step")
    public ComponentMainMenu getMainMenu() {
        return mainMenu;
    }
}
