package io.testomat.manufactura_light_im;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @BeforeEach
    public void login() {
        open("https://app.testomat.io");

        //enter credentials and submit
        $("#content-desktop #user_email").setValue("mailforivanna@gmail.com");
        $("#content-desktop #user_password").setValue("75Qke9cBV@3nvCL");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }

    @Test
    public void userNavigateToEmptyProjectPage() {
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

    @Test
    public void userNavigateToProjectWithSuitesPage() {

        //select company
        $("#company_id").click();
        $(byText("QA Club Lviv")).click();

        //search project
        $("#search").setValue("Manufacture Testomatio");

        //open project page
        $(byText("Manufacture Testomatio")).click();

        //project page is loaded
        $(".first h2").shouldHave(text("Manufacture Testomatio"));
        $("[aria-label=\"Tabs\"]").shouldBe(visible);
        $x("//*[@id=\"ember53\"]/* ").should(exist);
    }

    @AfterEach
    public void logout() {
        open("https://app.testomat.io");
        $("#user-menu-button").click();
        $("[type=\"submit\"]").shouldHave(text("Sign Out")).click();
    }

}