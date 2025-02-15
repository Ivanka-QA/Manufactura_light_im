package io.testomat.manufactura_light_im;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.manufactura_light_im.utils.StringParsers.parseIntegerFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageHelper {
    static void tileTestsCounterShouldBeEqualTo(String projectName, int expectedTetsCounter) {
        String projectTileTestsCounterSelector = String.format("[title='%s'] p", projectName);

        String textWithTestsCounter = $(projectTileTestsCounterSelector).getText();
        Integer testsCounter = parseIntegerFromString(textWithTestsCounter);

        assertEquals(expectedTetsCounter, testsCounter);
    }
}
