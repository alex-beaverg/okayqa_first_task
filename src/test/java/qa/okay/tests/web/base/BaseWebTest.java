package qa.okay.tests.web.base;

import io.qameta.allure.Step;
import org.testng.Assert;
import qa.okay.pages.HomePage;
import qa.okay.utils.WebDriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseWebTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Step(value = "Setup method before test")
    public void setup() {
        driver = WebDriverService.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    @Step(value = "Tear Down method after test")
    public void teardown() {
        WebDriverService.closeDriver();
    }

    @Step(value = "Getting Home Page step")
    public HomePage getHomePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageOpen(), "Home Page isn't open!");
        return new HomePage(driver);
    }
}
