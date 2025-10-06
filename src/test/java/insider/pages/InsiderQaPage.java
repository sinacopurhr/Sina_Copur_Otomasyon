package insider.pages;

import insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsiderQaPage {

    public InsiderQaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="wt-cli-accept-all-btn")
    public static WebElement acceptAllCookiesButton;

    @FindBy(xpath ="//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']")
    public WebElement seeAllQaElements;

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[1]")
    public WebElement filterByLocationDropDown;

    @FindBy(css = "span[id=select2-filter-by-department-container]")
    public WebElement filterByDeptDropDown;

    @FindBy(xpath = "//*[@id='select2-filter-by-department-container' and @title='Quality Assurance']")
    public WebElement QaFromDropdown;

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single' and @aria-activedescendant='select2-filter-by-location-result-o08y-All'])[1]")
    public WebElement locationDropDownIsOpen;

    @FindBy(xpath = "//li[@role='option' and normalize-space()='Istanbul, Turkiye']")
    public WebElement selectIstanbulTurkiyeButton;

    @FindBy(css = "#jobs-list")
    public WebElement jobsList;

    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")
    public WebElement jobsListPosition;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    public WebElement jobsListDepartment;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    public WebElement jobsListLocation;

    @FindBy(css = "a[class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5']")
    public static WebElement viewRoleButton;

    public static void switchToNewWindow(){
        String original = Driver.getDriver().getWindowHandle();
        viewRoleButton.click();
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(original)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }





}
