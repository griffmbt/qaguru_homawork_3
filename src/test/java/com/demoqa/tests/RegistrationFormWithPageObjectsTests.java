package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;

import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobby)
                .uploadPicture(uploadPictureSrc)
                .setCurrentAddress(currentAddress)
                .setStateAndCityComponent(userState, userCity)
                .clickSubmit()

                .checkResultsTableVisible()
                .checkResult("Student Name", userFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Date of Birth", userDateOfBirth)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", userStateAndCity);

    }
}
