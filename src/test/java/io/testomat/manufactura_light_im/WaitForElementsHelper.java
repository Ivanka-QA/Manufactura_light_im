package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WaitForElementsHelper {
    static void waitForEmptyProjectIsLoaded() {
        $(".empty h2").shouldHave(text("\uD83E\uDE84 Let's do some testing!\n"));
    }

    static void waitForProjectWithSuitesIsLoaded(String projectName) {
        $(".first h2").shouldHave(text(projectName));
        $("[aria-label=\"Tabs\"]").shouldBe(visible);
        $x("//*[@id=\"ember53\"]/* ").should(exist);
    }
}
