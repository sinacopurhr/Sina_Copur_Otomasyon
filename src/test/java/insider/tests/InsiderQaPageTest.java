package insider.tests;
import insider.pages.InsiderQaPage;
import insider.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static insider.pages.InsiderQaPage.navigateToQaJobsPage;
import static insider.pages.InsiderQaPage.switchToNewWindow;
import static insider.utilities.BrowserUtilities.jsExecutor;
import static insider.utilities.Driver.closeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Reporter.log;

public class InsiderQaPageTest  {

    InsiderQaPage insiderQaPage = new InsiderQaPage();
    WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(),10);
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void insiderUseQaCareersPageTest(){

        navigateToQaJobsPage();

        webDriverWait.until(ExpectedConditions.visibilityOf(insiderQaPage.QaFromDropdown));
        insiderQaPage.filterByLocationDropDown.click();
        actions.moveToElement(insiderQaPage.selectIstanbulTurkiyeButton);
        insiderQaPage.selectIstanbulTurkiyeButton.click();


        jsExecutor(insiderQaPage.jobsList);
        assertTrue(insiderQaPage.jobsList.isDisplayed());
        log("List of available positions are displayed",true);


        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                insiderQaPage.jobsListPosition, "Quality Assurance"));
        assertTrue(insiderQaPage.jobsListPosition.getText().contains("Quality Assurance"));
        log("Position descripton contains Quality Assurance",true);


        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                insiderQaPage.jobsListDepartment, "Quality Assurance"));
        assertTrue(insiderQaPage.jobsListDepartment.getText().contains("Quality Assurance"));
        log("Department descripton contains Quality Assurance",true);


        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                insiderQaPage.jobsListLocation, "Istanbul, Turkiye"));
        assertTrue(insiderQaPage.jobsListLocation.getText().contains("Istanbul, Turkiye"));
        log("Location descripton contains Quality Assurance",true);


        switchToNewWindow();
        assertEquals(Driver.getDriver().getTitle(), "Insider. - Software Quality Assurance Engineer");
        log("New Window Handle is received");

        closeDriver();

    }
}
