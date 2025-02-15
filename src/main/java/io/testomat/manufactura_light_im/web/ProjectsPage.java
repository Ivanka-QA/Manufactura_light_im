package io.testomat.manufactura_light_im.web;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {
    public void open() {
        Selenide.open("/");
    }

    public void selectCompany(String companyName) {
        $("#company_id").click();
        $(byText(companyName)).click();
    }

    public void searchProject(String projectName) {
        String projectTileSelector = String.format("[title='%s']", projectName);
        $("#search").setValue(projectName);
        $(projectTileSelector).shouldBe(visible);

    }

    public String getTestsTotalCountFromProjectTile(String projectName) {
        String projectTileTestsCounterSelector = String.format("[title='%s'] p", projectName);

        return $(projectTileTestsCounterSelector).getText();

    }

    public void openProject(String projectName) {
        $(byText(projectName)).shouldHave(exactText(projectName)).click();
    }

    public void pageIsLoaded() {
        $("#container").shouldBe(visible);
    }
}
