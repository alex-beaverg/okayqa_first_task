package qa.okay.tests.web.interactions;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.pages.HomePage;
import qa.okay.pages.main_pages.InteractionsPage;
import qa.okay.pages.sub_pages.interactions.DroppablePage;

import static qa.okay.utils.PropertyGetter.getData;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Interactions")
public class DroppableTest extends BaseWebTest {

    @Test(description = "Verify 'Drag and drop' of element operation Test")
    @Description(value = "Verify 'Drag and drop' of element operation")
    @Severity(SeverityLevel.NORMAL)
    public void verifyDragAndDropOperationTest() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        InteractionsPage interactionsPage = homePage.getMainMenu().clickInteractionsItem();
        sa.assertTrue(interactionsPage.isMainPageOpen(getData("MainPages.text")), "Interactions Page isn't open!");

        DroppablePage droppablePage = interactionsPage.clickDroppableItem();
        sa.assertTrue(droppablePage.isSubPageOpen(getData("SubPages.Droppable.title")), "Droppable Page isn't open!");

        droppablePage.dragAndDropElement();
        sa.assertEquals(droppablePage.getTextFromDropHere(), getData("Droppable.text"), "Element isn't dropped!");

        sa.assertAll();
    }
}
