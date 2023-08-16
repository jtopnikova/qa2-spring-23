import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTests {
    private final By REGISTRATION_FORM = By.id("registration-Form");
    private final By FIRST_NAME_INPUT_FIELD = By.name("first-name");
    private final By REGISTRATION_BTN = By.xpath(".//span[@class='smart-net-banner__info-button-text']");
    private final By LOGO = By.tagName("img");
    private final By SEARCH_INPUT = By.id("q");

    @Test
    public void firstSeleniumTry () {
        WebDriver browser = new ChromeDriver();
        browser.get("http://1a.lv");

//        WebElement registrationForm = browser.findElement(locator); //search inside page
//        registrationForm.findElement(anotherLocator); //search inside element
    }
}
