package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CssXpathExamples {

    // group: https://t.me/xpath_help
    // hints: https://devhints.io/xpath
    void cssXpathExamples() {
        open("url");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
        $(by("data-testid", "royal_email")).setValue("some@email.com");
        $("[data-testid=royal_email]").setValue("some@email.com");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("#email").setValue("some@email.com");
        $(byId("email")).setValue("some@email.com");
        $("[id='email']").setValue("some@email.com");
        $("input[id='email']").setValue("some@email.com");
        $("input#email").setValue("some@email.com");
        $(by("id", "email")).setValue("some@email.com");

        $x("//input[@id='email']").setValue("some@email.com");
        $x("//*[@id='email']").setValue("some@email.com");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name='email']").setValue("some@email.com");
        $("input[name='email']").setValue("some@email.com");
        $(by("name", "email")).setValue("some@email.com");
        $(byName("email")).setValue("some@email.com");

        $x("//input[@name='email']").setValue("some@email.com");
        $x("//*[@name='email']").setValue("some@email.com");

        // <input type="email" class="inputtext login_form_input_box">
        $(byClassName("login_form_input_box")).setValue("some@email.com");
        $(".login_form_input_box").setValue("some@email.com");
        $(".inputtext.login_form_input_box").setValue("some@email.com");
        $("input.inputtext.login_form_input_box").setValue("some@email.com");

        $x("//*[@class='login_form_input_box']").setValue("some@email.com");


        // <div type="email" class="inputtext">
        //      <input class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("some@email.com");


    }

}