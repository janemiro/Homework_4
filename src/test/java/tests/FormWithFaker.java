package tests;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormWithFaker {
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = fakeValuesService.bothify("????##@gmail.com"),
            gender = "Other",
            userNumber = "1234567890",
            dayOfBirth = "03",
            monthOfBirth = "June",
            yearOfBirth = "1984",
            subject1 = "English",
            subject2 = "Computer Science",
            hobby1 = "Reading",
            hobby2 = "Music",
            currentAddress = "On the Roof, 5",
            state = "Haryana",
            city = "Panipat",
            picture = "1.png";

    @Test
    public void FormTest() {
        open("https://demoqa.com/automation-practice-form");

        // имя, мейл
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);

        // пол
        $(byText(gender)).click();

        // мобильный
        $("#userNumber").val(userNumber);

        // календарь
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $$(".react-datepicker__day--0" + dayOfBirth)
                .filter(not(cssClass("react-datepicker__day--outside-month")))
                .first().click();

        // предметы
        $("#subjectsInput").val(subject1).pressEnter();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();

        // хобби
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();

        // загрузить картинку
        $("#uploadPicture").uploadFromClasspath(picture);

        // адрес
        $("#currentAddress").val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        // сабмит
        $("#submit").click();

        // посмотреть результат
        Selenide.sleep(3000);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text(gender));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2));
        $x("//td[text()='Picture']").parent().shouldHave(text("1.png"));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));


    }
}
