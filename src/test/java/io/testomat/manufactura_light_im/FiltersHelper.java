package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FiltersHelper {
    static void selectCompany(String companyName) {
        $("#company_id").click();
        $(byText(companyName)).click();
    }

    static void searchProject(String projectName) {
        String projectTileSelector = String.format("[title='%s']", projectName);
        $("#search").setValue(projectName);
        $(projectTileSelector).shouldBe(visible);

    }

}
