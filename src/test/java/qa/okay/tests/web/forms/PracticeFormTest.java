package qa.okay.tests.web.forms;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.okay.tests.web.base.BaseWebTest;
import qa.okay.components.ModalResultTable;
import qa.okay.domain.web.Student;
import qa.okay.pages.main_pages.FormsPage;
import qa.okay.pages.HomePage;
import qa.okay.pages.sub_pages.forms.PracticeFormPage;

import static qa.okay.utils.PropertyGetter.*;
import static qa.okay.services.StudentService.*;

@Epic(value = "Demo QA dot com")
@Feature(value = "Web")
@Story(value = "Forms")
public class PracticeFormTest extends BaseWebTest {

    @Test(description = "Verify entering to the Practice Form data Test")
    @Description(value = "Verify entering to the Practice Form data")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPracticeFormTest() {
        HomePage homePage = getHomePage();
        SoftAssert sa = new SoftAssert();

        FormsPage formsPage = homePage.getMainMenu().clickFormsItem();
        sa.assertTrue(formsPage.isMainPageOpen(getData("MainPages.text")), "Forms Page isn't open!");

        PracticeFormPage practiceFormPage = formsPage.clickPracticeFormItem();
        sa.assertTrue(practiceFormPage.isSubPageOpen(getData("SubPages.PracticeForm.title")), "Practice Form Page isn't open!");

        Student studentFromData = createStudentFromData();
        ModalResultTable resultTable = practiceFormPage.fillInForm(studentFromData);
        Student studentFromResultTable = createStudentFromResultTable(resultTable);
        sa.assertEquals(studentFromData, studentFromResultTable, "Students aren't equal!");
        sa.assertTrue(studentFromData.getPicturePath().contains(studentFromResultTable.getPicturePath()), "Students' Pictures aren't equal!");

        sa.assertAll();
    }
}
