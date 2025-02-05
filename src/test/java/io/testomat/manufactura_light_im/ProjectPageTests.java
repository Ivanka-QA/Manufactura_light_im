package io.testomat.manufactura_light_im;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void firstTest() {
        open("https://app.testomat.io");

        //login user
        $("#content-desktop #user_email").setValue("mailforivanna@gmail.com");
        $("#content-desktop #user_password").setValue("75Qke9cBV@3nvCL");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(Condition.visible);

        //search project
        $("#search").setValue("Manufacture light");

        //select project
        $(byText("Manufacture light")).click();
        //project is loaded
        //$(byText("Manufacture light")).shouldBe(Condition.visible);
        $("h2").shouldHave(Condition.text("Manufacture light"));
        sleep(10000);




    }
}