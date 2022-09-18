package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker(new Locale("en"));

    String firstName,
            lastName,
            userFullName,
            userEmail,
            gender,
            userNumber,
            day,
            month,
            year,
            userDateOfBirth,
            hobby,
            currentAddress,
            userStateAndCity;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userFullName = format("%s %s", firstName, lastName);
        userEmail = faker.internet().emailAddress();
        gender = getRandomGender();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1, 30) + "";
        month = getRandomMonth();
        year = faker.number().numberBetween(1900, 2010) + "";
        userDateOfBirth = format("%s %s,%s", day, month, year);
        hobby = getRandomHobby();
        currentAddress = faker.address().fullAddress();
        userStateAndCity = format("%s %s", userState, userCity);
    }

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
