package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthHelper {

    public static void logout() {
        $("#user-menu-button").click();
        $("[type=\"submit\"]").shouldHave(text("Sign Out")).click();
    }
}
