package qa.okay.services;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import qa.okay.components.ModalResultTable;
import qa.okay.domain.web.Student;

import java.util.List;

import static qa.okay.utils.PropertyGetter.*;

public class StudentService {

    @Step(value = "Creating Student from test data property file step")
    public static Student createStudentFromData() {
        Student student = new Student();
        student.setFirstName(getData("Form.firstName"));
        student.setLastName(getData("Form.lastName"));
        student.setEmail(getData("Form.email"));
        student.setGender(getData("Form.gender"));
        student.setPhone(getData("Form.phone"));
        student.setDateOfBirth(getData("Form.dateOfBirth"));
        student.setSubjects(getData("Form.subjects"));
        student.setHobbies(getData("Form.hobbies"));
        student.setPicturePath(getData("Form.picturePath"));
        student.setAddress(getData("Form.address"));
        student.setState(getData("Form.state"));
        student.setCity(getData("Form.city"));
        return student;
    }

    @Step(value = "Creating Student from result table step")
    public static Student createStudentFromResultTable(ModalResultTable resultTable) {
        List<WebElement> results = resultTable.getResults();
        Student student = new Student();
        student.setFirstName(results.get(0).getText().split(" ")[0]);
        student.setLastName(results.get(0).getText().split(" ")[1]);
        student.setEmail(results.get(1).getText());
        student.setGender(results.get(2).getText());
        student.setPhone(results.get(3).getText());
        student.setDateOfBirth(results.get(4).getText().replaceAll(",", " "));
        student.setSubjects(results.get(5).getText().replaceAll(",", ""));
        student.setHobbies(results.get(6).getText().replaceAll(",", ""));
        student.setPicturePath(results.get(7).getText());
        student.setAddress(results.get(8).getText());
        student.setState(results.get(9).getText().split(" ")[0]);
        student.setCity(results.get(9).getText().split(" ")[1]);
        return student;
    }
}
