package insider.utilities;

import insider.pages.InsiderQaPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static insider.pages.InsiderQaPage.viewRoleButton;

public class BrowserUtilities {


    ;

    /*
            This method will accept int (in seconds) and execute Thread.sleep
            for given duration
             */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void jsExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }


}
