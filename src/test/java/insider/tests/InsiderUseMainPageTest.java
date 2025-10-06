package insider.tests;

import insider.pages.InsiderUseMainPage;
import org.testng.annotations.Test;
import static insider.pages.InsiderUseMainPage.navigateToCareersPage;
import static insider.utilities.BrowserUtilities.sleep;
import static insider.utilities.Driver.closeDriver;
import static org.testng.Assert.assertTrue;
import static org.testng.Reporter.log;

public class InsiderUseMainPageTest {

    InsiderUseMainPage insiderUseMainPage = new InsiderUseMainPage();

    @Test
    public void insiderUseMainPagetest() {

        navigateToCareersPage();

        InsiderUseMainPage.jsExecutor(insiderUseMainPage.findYourCallingTitle);
        assertTrue(insiderUseMainPage.findYourCallingTitle.isDisplayed(),
                "Expected: 'Find Your Calling' title is displayed");
        log("'Find Your Calling' title is displayed",true);

        assertTrue(insiderUseMainPage.verifyTeamList(insiderUseMainPage.teamList));
        log("'Team List' is displayed and clickable",true);

        sleep(2);
        InsiderUseMainPage.jsExecutor(insiderUseMainPage.ourLocationsTitle);
        assertTrue(insiderUseMainPage.ourLocationsTitle.isDisplayed(),
                "Expected: 'Our Locations' title is displayed");

        sleep(2);
        assertTrue(insiderUseMainPage.verifyLocationList(insiderUseMainPage.locationList));
        log("'Location List' is displayed and clickable",true);

        InsiderUseMainPage.jsExecutor(insiderUseMainPage.lifeAtInsiderTitle);
        sleep(2);
        assertTrue(insiderUseMainPage.lifeAtInsiderTitle.isDisplayed());
        log("'Life At Insider' title is displayed",true);

        closeDriver();
    }
}
