import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketsTests {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class=\"gogogo\"]");

    //private final By SELECTED_AIRPORT = By.xpath(".//span[@class=\"bTxt\"]");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULT_COUNT_INPUT = By.id("adults");
    private final By CHILDREN_COUNT_INPUT = By.id("children");
    private final By BAGS_COUNT_INPUT = By.id("bugs");
    private final By SELECTED_FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick = 'setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class=\"bTxt\"]");

    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE = "RIX";
    private final String ARRIVAL = "MEL";

    private final String NAME = "Julija";
    private final String SURNAME = "Topnikova";
    private final String DISCOUNT = "50OFF";
    private final String ADULT_COUNT = "2";
    private final String CHILDREN_COUNT = "0";
    private final String BAGS_COUNT = "1";
    private final String FLIGHT = "13";

    @Test
    public void successTicketsBookCheck() {
        //open browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        //open home page
        browser.get(URL);

        //select departure airport
        WebElement fromDropdown = browser.findElement(FROM);
        Select fromSelect = new Select(fromDropdown);
        fromSelect.selectByValue(DEPARTURE);

        //select arrival airport
        WebElement toDropdown = browser.findElement(TO);
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL);

        //press gogogo btn
        browser.findElement(GO_BTN).click();

        //check if selected airports appear
        //List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
       // System.out.println("First airport " + selectedAirports.get(0).getText());
       // System.out.println("Second airport " + selectedAirports.get(1).getText());

        //fill in passenger info
        WebElement nameInputField = browser.findElement(NAME_INPUT);
        nameInputField.clear();
        nameInputField.sendKeys(NAME);

        WebElement surnameInputField = browser.findElement(SURNAME_INPUT);
        surnameInputField.clear();
        surnameInputField.sendKeys(SURNAME);

        WebElement discountInputField = browser.findElement(DISCOUNT_INPUT);
        discountInputField.clear();
        discountInputField.sendKeys(DISCOUNT);

        WebElement adultsInputField = browser.findElement(ADULT_COUNT_INPUT);
        adultsInputField.clear();
        adultsInputField.sendKeys(ADULT_COUNT);

        WebElement childrenInputField = browser.findElement(CHILDREN_COUNT_INPUT);
        childrenInputField.clear();
        childrenInputField.sendKeys(CHILDREN_COUNT);

        WebElement bagsInputField = browser.findElement(BAGS_COUNT_INPUT);
        bagsInputField.clear();
        bagsInputField.sendKeys(BAGS_COUNT);

        WebElement flightDropdown = browser.findElement(SELECTED_FLIGHT);
        Select flightSelect = new Select(flightDropdown);
        flightSelect.selectByValue(FLIGHT);

        //press get price link
        browser.findElement(GET_PRICE_LINK).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE, flightInfo.get(0).getText(), "Wrong Departure Airport");
        Assertions.assertEquals(ARRIVAL, flightInfo.get(1).getText(), "Wrong Arrival Airport");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong Name");

        Assertions.assertEquals(DEPARTURE, flightInfo.get(3).getText(), "Wrong Departure Airport");
        Assertions.assertEquals(ARRIVAL, flightInfo.get(4).getText(), "Wrong Arrival Airport");

        //press book btn
        //select seat number
        //press book btn
        //check if successful msg appears

    }

}

