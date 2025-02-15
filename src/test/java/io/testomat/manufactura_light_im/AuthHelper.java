package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AuthHelper {

    public static void logout() {
        $("#user-menu-button").click();
        $("[type=\"submit\"]").shouldHave(text("Sign Out")).click();
    }
}
