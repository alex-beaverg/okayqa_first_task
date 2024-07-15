package qa.okay.domain.web;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String subjects;
    private String dateOfBirth;
    private String hobbies;
    private String picturePath;
    private String address;
    private String state;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // equals() and hashcode() are implemented with every field except picturePath

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(email, student.email) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(subjects, student.subjects) &&
                Objects.equals(dateOfBirth, student.dateOfBirth) &&
                Objects.equals(hobbies, student.hobbies) &&
                Objects.equals(address, student.address) &&
                Objects.equals(state, student.state) &&
                Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, gender, phone, subjects, dateOfBirth, hobbies,
                address, state, city);
    }
}
