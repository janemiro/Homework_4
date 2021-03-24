package tests.pageobjects;

import org.junit.jupiter.api.Test;

public class FormTests {
    FormPage formPage = new FormPage();

    @Test
    void OkFormTest(){
        formPage.openPage();
        formPage.fillForm();
        formPage.check();
    }
}





