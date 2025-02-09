package io.testomat.manufactura_light_im;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.testomat.manufactura_light_im.FiltersHelper.searchProject;
import static io.testomat.manufactura_light_im.FiltersHelper.selectCompany;
import static io.testomat.manufactura_light_im.HomePageHelper.tileTestsCounterShouldBeEqualTo;
import static io.testomat.manufactura_light_im.NavigationHelper.navigateToHomePage;
import static io.testomat.manufactura_light_im.NavigationHelper.openProject;
import static io.testomat.manufactura_light_im.WaitForElementsHelper.waitForEmptyProjectIsLoaded;
import static io.testomat.manufactura_light_im.WaitForElementsHelper.waitForProjectWithSuitesIsLoaded;

public class ProjectPageTests extends BaseTest{

    String username = env.get("USERNAME");
    String password = env.get("PASSWORD");

    @BeforeEach
    public void setup() {
        navigateToHomePage();

        AuthHelper.login(username, password);
    }

    @Test
    public void userNavigateToEmptyProjectPage() {
        String projectName = "Manufacture light";

        selectCompany("QA Club Lviv");

        searchProject(projectName);

        tileTestsCounterShouldBeEqualTo(projectName, 0);

        openProject(projectName);

        waitForEmptyProjectIsLoaded();

    }

    @Test
    public void userNavigateToProjectWithSuitesPage() {
        String projectName = "Manufacture Testomatio";

        selectCompany("QA Club Lviv");

        searchProject(projectName);

        openProject(projectName);

        waitForProjectWithSuitesIsLoaded(projectName);
    }



    @AfterEach
    public void cleanup() {
        navigateToHomePage();
        AuthHelper.logout();
    }

}