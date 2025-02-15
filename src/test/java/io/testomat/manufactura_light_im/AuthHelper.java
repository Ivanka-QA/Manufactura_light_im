package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AuthHelper {
    public static void login(String username, String password) {

        $("#content-desktop #user_email").setValue(username);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);

    }

    public static void logout() {
        $("#user-menu-button").click();
        $("[type=\"submit\"]").shouldHave(text("Sign Out")).click();
    }
}
