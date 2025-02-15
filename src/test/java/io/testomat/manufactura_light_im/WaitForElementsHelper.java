package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WaitForElementsHelper {
    static void waitForEmptyProjectIsLoaded() {
        $(".empty h2").shouldHave(text("Let's do some testing!"));
    }

    static void waitForProjectWithSuitesIsLoaded(String projectName) {
        $(".first h2").shouldHave(text(projectName));
        $("[aria-label=\"Tabs\"]").shouldBe(visible);
        $x("//*[contains(@class, \"dragSortList\")]/* ").should(exist);
    }
}
