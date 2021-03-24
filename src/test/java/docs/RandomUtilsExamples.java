package docs;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomEmail;

public class RandomUtilsExamples {

    @Test
    void randomExample() {
        String randomString = getRandomString(11);

//        $("#firstName").val(randomString);
        System.out.println(randomString);

        String randomMessage = getRandomMessage(22, 100);
        System.out.println(randomMessage);

        int randomInt = getRandomInt(223333, 100000000);
        System.out.println(randomInt + "");

        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }
}