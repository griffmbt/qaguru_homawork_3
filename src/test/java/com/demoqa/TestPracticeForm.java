package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Silver");

        $("#userEmail").setValue("JohnSilver@gmaiil.con");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9933789987");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $("[aria-label=\"Choose Sunday, May 30th, 1993\"]").shouldHave(text("30")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpeg"));
        $("#currentAddress").setValue("Lenina st.");

        $("#state .css-1wa3eu0-placeholder").click();
        $("#react-select-3-option-1").click();
        $("#city .css-1wa3eu0-placeholder").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("John Silver"));
        $(".table-responsive").shouldHave(text("JohnSilver@gmaiil.con"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9933789987"));
        $(".table-responsive").shouldHave(text("30 May,1993"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("cat.jpeg"));
        $(".table-responsive").shouldHave(text("Lenina st."));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Lucknow"));


    }
}
