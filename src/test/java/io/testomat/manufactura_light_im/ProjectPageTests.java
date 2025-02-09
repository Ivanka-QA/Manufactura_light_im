package io.testomat.manufactura_light_im;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void userNavigateToEmptyProjectPage() {
        open("https://app.testomat.io");

        //login user
        $("#content-desktop #user_email").setValue("mailforivanna@gmail.com");
        $("#content-desktop #user_password").setValue("75Qke9cBV@3nvCL");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);

        //select company
        $("#company_id").click();
        $(byText("QA Club Lviv")).click();

        //search project
        $("#search").setValue("Manufacture light");

        //select project
        $(byText("Manufacture light")).click();

        //project is loaded
        $(".empty h2").shouldHave(text("\uD83E\uDE84 Let's do some testing!\n"));

    }

}