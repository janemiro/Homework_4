package tests;

import org.junit.jupiter.api.Test;
import pageobjects.FormPage;

public class FormTests {
    FormPage formPage = new FormPage();

    @Test
    void formTest(){
        formPage.openPage();
        formPage.fillForm();
        formPage.check();
    }
}





