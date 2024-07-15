package qa.okay.pages.sub_pages.forms;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import qa.okay.base.BaseElement;
import qa.okay.components.ModalResultTable;
import qa.okay.domain.web.Student;
import qa.okay.utils.Waits;

import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BaseElement {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@id='genterWrapper']//div/div/label")
    private List<WebElement> genderRadioButtons;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsInput;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']//div/div/label")
    private List<WebElement> hobbyCheckBoxes;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement uploadPictureInput;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement addressTextArea;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    private WebElement cityInput;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Entering first name sub-step")
    private void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    @Step(value = "Entering last name sub-step")
    private void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    @Step(value = "Entering email sub-step")
    private void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step(value = "Choosing gender radio button sub-step")
    private void clickGenderRadioButton(String gender) {
        for (WebElement radio : genderRadioButtons) {
            if (radio.getText().equals(gender)) {
                radio.click();
            }
        }
    }

    @Step(value = "Entering phone number sub-step")
    private void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    @Step(value = "Entering date of birth sub-step")
    private void enterDateOfBirth(String dateOfBirth) {
        dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        dateOfBirthInput.sendKeys(dateOfBirth);
        dateOfBirthInput.sendKeys(Keys.ESCAPE);
    }

    @Step(value = "Entering subjects sub-step")
    private void enterSubjects(String subjects) {
        scrollPage();
        List<String> subjectList = Arrays.stream(subjects.split(" ")).toList();
        for (String subject : subjectList) {
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.ENTER);
        }
    }

    @Step(value = "Choosing hobby check boxes sub-step")
    private void clickHobbyCheckBoxes(String hobbies) {
        List<String> hobbyList = Arrays.stream(hobbies.split(" ")).toList();
        for (String hobby : hobbyList) {
            for (WebElement checkBox : hobbyCheckBoxes) {
                if (checkBox.getText().equals(hobby)) {
                    checkBox.click();
                }
            }
        }
    }

    @Step(value = "Uploading picture sub-step")
    private void uploadPicture(String path) {
        uploadPictureInput.sendKeys(path);
    }

    @Step(value = "Entering address sub-step")
    private void enterAddress(String address) {
        addressTextArea.sendKeys(address);
    }

    @Step(value = "Entering state sub-step")
    private void enterState(String state) {
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }

    @Step(value = "Entering city sub-step")
    private void enterCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step(value = "Clicking submit button sub-step")
    private void clickSubmitButton() {
        scrollPage();
        submitButton.click();
    }

    @Step(value = "Filling in Practice Form step")
    public ModalResultTable fillInForm(Student student) {
        enterFirstName(student.getFirstName());
        enterLastName(student.getLastName());
        enterEmail(student.getEmail());
        clickGenderRadioButton(student.getGender());
        enterPhone(student.getPhone());
        enterDateOfBirth(student.getDateOfBirth());
        enterSubjects(student.getSubjects());
        clickHobbyCheckBoxes(student.getHobbies());
        uploadPicture(student.getPicturePath());
        enterAddress(student.getAddress());
        enterState(student.getState());
        enterCity(student.getCity());
        clickSubmitButton();
        return new ModalResultTable(driver);
    }
}
