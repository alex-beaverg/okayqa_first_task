package qa.okay.tests.web.widgets;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.pages.HomePage;
import qa.okay.pages.main_pages.WidgetsPage;
import qa.okay.pages.sub_pages.widgets.SliderPage;

import static qa.okay.utils.PropertyGetter.getData;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Widgets")
public class SliderTest extends BaseWebTest {

    @Test(description = "Verify moving Slider to max position Test")
    @Description(value = "Verify moving Slider to max position")
    @Severity(SeverityLevel.NORMAL)
    public void verifyMovingSliderToMaxTest() {
        SliderPage sliderPage = getSliderPage();

        sliderPage.moveSliderToMax();
        Assert.assertEquals(sliderPage.getSliderValue(), getData("Slider.maxValue"), "Slider values aren't equal!");
    }

    @Test(description = "Verify moving Slider to min position Test")
    @Description(value = "Verify moving Slider to min position")
    @Severity(SeverityLevel.NORMAL)
    public void verifyMovingSliderToMinTest() {
        SliderPage sliderPage = getSliderPage();

        sliderPage.moveSliderToMin();
        Assert.assertEquals(sliderPage.getSliderValue(), getData("Slider.minValue"), "Slider values aren't equal!");
    }

    @Step(value = "Getting Slider Page step")
    private SliderPage getSliderPage() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        WidgetsPage widgetsPage = homePage.getMainMenu().clickWidgetsItem();
        sa.assertTrue(widgetsPage.isMainPageOpen(getData("MainPages.text")), "Widgets Page isn't open!");

        SliderPage sliderPage = widgetsPage.clickSliderItem();
        sa.assertTrue(sliderPage.isSubPageOpen(getData("SubPages.Slider.title")), "Slider Page isn't open!");

        sa.assertAll();
        return sliderPage;
    }
}
