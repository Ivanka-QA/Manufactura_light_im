package io.testomat.manufactura_light_im;

import io.testomat.manufactura_light_im.web.ProjectPage;
import io.testomat.manufactura_light_im.web.ProjectsPage;
import io.testomat.manufactura_light_im.web.SignInPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.testomat.manufactura_light_im.utils.StringParsers.parseIntegerFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectPageTests extends BaseTest{

    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    private static final SignInPage signInPage = new SignInPage();
    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void openSignInPageAndLogin() {
        signInPage.open();
        signInPage.login(username, password);

    }

    @BeforeEach
    public void openProjectsPage() {
        projectsPage.open();
    }


    @Test
    public void userNavigatesToEmptyProjectPage() {
        String projectName = "Manufacture light";
        Integer expectedTetsCounter = 0;

        projectsPage.pageIsLoaded();
        projectsPage.selectCompany("QA Club Lviv");
        projectsPage.searchProject(projectName);
        var textWithTestsCounter = projectsPage.getTestsTotalCountFromProjectTile(projectName);
        Integer testsCounter = parseIntegerFromString(textWithTestsCounter);
        assertEquals(expectedTetsCounter, testsCounter);

        projectsPage.openProject(projectName);
        projectPage.emptyProjectPageIsLoaded();

    }

    @Test
    public void userNavigatesToProjectWithSuitesPage() {
        String projectName = "Manufacture Testomatio";

        projectsPage.pageIsLoaded();
        projectsPage.selectCompany("QA Club Lviv");
        projectsPage.searchProject(projectName);
        projectsPage.openProject(projectName);
        projectPage.projectPageWithSuitesIsLoaded(projectName);
    }



    @AfterAll
    public static void cleanup() {
        projectsPage.open();
        AuthHelper.logout();
    }

}