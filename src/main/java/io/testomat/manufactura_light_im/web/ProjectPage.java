package io.testomat.manufactura_light_im.web;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    public void emptyProjectPageIsLoaded() {
        $(".empty h2").shouldHave(text("Let's do some testing!"));
    }

    public void projectPageWithSuitesIsLoaded(String projectName) {
        $(".first h2").shouldHave(text(projectName));
        $("[aria-label=\"Tabs\"]").shouldBe(visible);
        $x("//*[contains(@class, \"dragSortList\")]/* ").should(exist);
    }

}
