package qa.okay.tests.web.widgets;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.pages.HomePage;
import qa.okay.pages.main_pages.WidgetsPage;
import qa.okay.pages.sub_pages.widgets.ProgressBarPage;

import static qa.okay.utils.PropertyGetter.getData;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Widgets")
public class ProgressBarTest extends BaseWebTest {

    @Test(description = "Verify completing and reset Progress Bar actions Test")
    @Description(value = "Verify completing and reset Progress Bar actions")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCompletingAndResetProgressBarActionsTest() {
        ProgressBarPage progressBarPage = getProgressBarPage();
        SoftAssert sa = new SoftAssert();

        progressBarPage.clickStartStopButton();
        sa.assertTrue(progressBarPage.isProgressBarComplete(), "Progress Bar isn't complete!");

        progressBarPage.clickResetButton();
        sa.assertTrue(progressBarPage.isProgressBarReset(), "Progress Bar isn't reset!");

        sa.assertAll();
    }

    @Step(value = "Getting Progress Bar Page step")
    private ProgressBarPage getProgressBarPage() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        WidgetsPage widgetsPage = homePage.getMainMenu().clickWidgetsItem();
        sa.assertTrue(widgetsPage.isMainPageOpen(getData("MainPages.text")), "Widgets Page isn't open!");

        ProgressBarPage progressBarPage = widgetsPage.clickProgressBarItem();
        sa.assertTrue(progressBarPage.isSubPageOpen(getData("SubPages.ProgressBar.title")), "Progress Bar Page isn't open!");

        sa.assertAll();
        return progressBarPage;
    }
}
