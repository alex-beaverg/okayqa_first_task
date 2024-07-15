package qa.okay.tests.web.alerts_frames_windows;

import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.pages.HomePage;
import qa.okay.pages.main_pages.AlertsWindowsPage;
import qa.okay.pages.sub_pages.alerts_frames_windows.AlertsPage;

import static qa.okay.utils.PropertyGetter.getData;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Alerts, Frames & Windows")
public class AlertsTest extends BaseWebTest {

    @Test(description = "Verify Alert message Test")
    @Description(value = "Verify Alert message")
    @Severity(SeverityLevel.NORMAL)
    public void verifyAlertMessageTest() {
        AlertsPage alertsPage = getAlertsPage();
        Alert alert = alertsPage.getAlert();
        Assert.assertEquals(alert.getText(), getData("Alerts.alertMessage"), "Messages aren't equal!");
        alertsPage.acceptAlert(alert);
    }

    @Test(description = "Verify Alert message after timer (5 sec) Test")
    @Description(value = "Verify Alert message after timer (5 sec)")
    @Severity(SeverityLevel.NORMAL)
    public void verifyTimerAlertMessageTest() {
        AlertsPage alertsPage = getAlertsPage();
        Alert alert = alertsPage.getTimerAlert();
        Assert.assertEquals(alert.getText(), getData("Alerts.timerAlertMessage"), "Messages aren't equal!");
        alertsPage.acceptAlert(alert);
    }

    @Test(description = "Verify Alert (Confirm) 'OK' message Test")
    @Description(value = "Verify Alert (Confirm) 'OK' message")
    @Severity(SeverityLevel.NORMAL)
    public void verifyConfirmOkMessageTest() {
        AlertsPage alertsPage = getAlertsPage();
        Alert alert = alertsPage.getConfirm();
        alertsPage.acceptAlert(alert);
        Assert.assertEquals(alertsPage.getConfirmResult(), getData("Alerts.confirmOkResult"), "Messages aren't equal!");
    }

    @Test(description = "Verify Alert (Confirm) 'Cancel' message Test")
    @Description(value = "Verify Alert (Confirm) 'Cancel' message")
    @Severity(SeverityLevel.NORMAL)
    public void verifyConfirmCancelMessageTest() {
        AlertsPage alertsPage = getAlertsPage();
        Alert alert = alertsPage.getConfirm();
        alertsPage.dismissAlert(alert);
        Assert.assertEquals(alertsPage.getConfirmResult(), getData("Alerts.confirmCancelResult"), "Messages aren't equal!");
    }

    @Test(description = "Verify Alert (Prompt) message Test")
    @Description(value = "Verify Alert (Prompt) message")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPromptMessageTest() {
        AlertsPage alertsPage = getAlertsPage();
        Alert alert = alertsPage.getPrompt(getData("Alerts.promptMessage"));
        alertsPage.acceptAlert(alert);
        Assert.assertTrue(alertsPage.getPromptResult().contains(getData("Alerts.promptMessage")), "Messages aren't equal!");
    }

    @Step(value = "Getting Alerts Page step")
    private AlertsPage getAlertsPage() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        AlertsWindowsPage alertsWindowsPage = homePage.getMainMenu().clickAlertsWindowsItem();
        sa.assertTrue(alertsWindowsPage.isMainPageOpen(getData("MainPages.text")), "Alerts Windows Page isn't open!");

        AlertsPage alertsPage = alertsWindowsPage.clickAlertsItem();
        sa.assertTrue(alertsPage.isSubPageOpen(getData("SubPages.Alerts.title")), "Alerts Page isn't open!");

        sa.assertAll();
        return alertsPage;
    }
}
