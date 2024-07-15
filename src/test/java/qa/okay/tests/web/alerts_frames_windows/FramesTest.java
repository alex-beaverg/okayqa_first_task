package qa.okay.tests.web.alerts_frames_windows;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.pages.HomePage;
import qa.okay.pages.main_pages.AlertsWindowsPage;
import qa.okay.pages.sub_pages.alerts_frames_windows.FramesPage;

import static qa.okay.utils.PropertyGetter.getData;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Alerts, Frames & Windows")
public class FramesTest extends BaseWebTest {

    @Test(description = "Compare messages from different frames Test")
    @Description(value = "Compare messages from different frames")
    @Severity(SeverityLevel.NORMAL)
    public void compareMessagesFromDifferentFramesTest() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        AlertsWindowsPage alertsWindowsPage = homePage.getMainMenu().clickAlertsWindowsItem();
        sa.assertTrue(alertsWindowsPage.isMainPageOpen(getData("MainPages.text")), "Alerts Windows Page isn't open!");

        FramesPage framesPage = alertsWindowsPage.clickFramesItem();
        sa.assertTrue(framesPage.isSubPageOpen(getData("SubPages.Frames.title")), "Frames Page isn't open!");

        sa.assertEquals(framesPage.getHeaderFromFirstFrame(), framesPage.getHeaderFromSecondFrame(), "Messages aren't equal!");
        sa.assertAll();
    }
}
