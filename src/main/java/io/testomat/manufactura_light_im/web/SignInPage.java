package io.testomat.manufactura_light_im.web;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    public void open() {
        Selenide.open("/users/sign_in");
    }

    public void login(String username, String password) {

        $("#content-desktop #user_email").setValue(username);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $("#container .common-flash-success").shouldBe(visible);
        $("#content-desktop #user_email").shouldBe(hidden);

    }
}
