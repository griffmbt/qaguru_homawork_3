package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName("John")
                .setLastName("Silver")
                .setEmail("JohnSilver@gmaiil.con")
                .setGender("Other")
                .setUserNumber("9933789987")
                .setBirthDate("30", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("src/test/resources/cat.jpeg")
                .setCurrentAddress("Some address 1")
                .setStateAndCityComponent("NCR", "Delhi")
                .clickSubmit()

                .checkResultsTableVisible()
                .checkResult("Student Name", "John Silver")
                .checkResult("Student Email", "JohnSilver@gmaiil.con")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9933789987")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "cat.jpeg")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");

    }
}
