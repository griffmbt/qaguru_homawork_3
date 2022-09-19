package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;
import static java.lang.String.format;

public class TestData {
    static Faker faker = new Faker(new Locale("en"));
    static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userFullName = format("%s %s", firstName, lastName),
            userEmail = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 30) + "",
            month = getRandomMonth(),
            year = faker.number().numberBetween(1900, 2010) + "",
            userDateOfBirth = format("%s %s,%s", day, month, year),
            hobby = getRandomHobby(),
            currentAddress = faker.address().fullAddress(),
            subjects = "Math",
            pictureName = "cat.jpeg",
            uploadPictureSrc = "src/test/resources/cat.jpeg",
            userState = "NCR",
            userCity = "Delhi",
            userStateAndCity = format("%s %s", userState, userCity);

}
