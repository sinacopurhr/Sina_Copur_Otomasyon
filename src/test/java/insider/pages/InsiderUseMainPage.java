package insider.pages;

import insider.utilities.ConfigurationReader;
import insider.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class InsiderUseMainPage {

    public InsiderUseMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="wt-cli-accept-all-btn")
    public static WebElement acceptAllCookiesButton;

    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    public static WebElement navigationBar;

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/']")
    public static WebElement careersPage;

    @FindBy(css = ".category-title-media")
    public WebElement findYourCallingTitle;

    @FindBy(css = ".text-center.mb-4.mb-xl-5")
    public List<WebElement> teamList;

    @FindBy(css = ".category-title-media.ml-0")
    public WebElement ourLocationsTitle;

    @FindBy(xpath = "(//p[@class='mb-0'])[position() <= 5]")
    public List<WebElement> locationList;

    @FindBy(xpath = "(//h2[@class='elementor-heading-title elementor-size-default'])[2]" )
    public WebElement lifeAtInsiderTitle;

    public static void navigateToCareersPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("useInsiderUrl"));
        acceptAllCookiesButton.click();
        navigationBar.click();
        careersPage.click();
    }

    public static void jsExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public boolean verifyTeamList(List<WebElement> teamList){
        for (WebElement teams : teamList) {
            boolean listOfTeams = teams.isDisplayed() && teams.isEnabled();
        }
        return true;
    }

    public boolean verifyLocationList(List<WebElement> locationList){
        for (WebElement locations : locationList) {
           boolean listOfLocations =  locations.isDisplayed() && locations.isEnabled();
        }
        return true;
    }
}
