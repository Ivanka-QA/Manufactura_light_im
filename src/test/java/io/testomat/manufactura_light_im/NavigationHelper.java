package io.testomat.manufactura_light_im;


import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NavigationHelper extends BaseTest {
    static String baseUrl = env.get("BASE_URL");

    public static void navigateToHomePage() {
        Selenide.open(baseUrl);

    }

    static void openProject(String projectName) {
        $(byText(projectName)).shouldHave(exactText(projectName)).click();
    }

}
