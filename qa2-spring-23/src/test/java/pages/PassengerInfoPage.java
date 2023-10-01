package pages;

import model.Tickets.Flight;
import model.Tickets.Passenger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PassengerInfoPage {
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULT_COUNT_INPUT = By.id("adults");
    private final By CHILDREN_COUNT_INPUT = By.id("children");
    private final By BAGS_COUNT_INPUT = By.id("bugs");
    private final By SELECTED_FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick = 'setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class=\"bTxt\"]");
    private final By BOOK_BTN = By.id("book2");


    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(Passenger passenger, Flight flight) {
        baseFunc.type(NAME_INPUT, passenger.getFirstName());
        baseFunc.type(SURNAME_INPUT, passenger.getLastName());
        baseFunc.type(DISCOUNT_INPUT, flight.getDiscount());
        baseFunc.type(ADULT_COUNT_INPUT, flight.getPassengersCount());
        baseFunc.type(CHILDREN_COUNT_INPUT, flight.getChildCount());
        baseFunc.type(BAGS_COUNT_INPUT, flight.getLuggageCount());
        baseFunc.selectByText(SELECTED_FLIGHT, flight.getFlightDate());

    }

    public void clickGetPrice() {
        baseFunc.click(GET_PRICE_LINK);
    }

    public void clickBook() {
        baseFunc.click(BOOK_BTN);
    }

    public String getDepartureAirport() {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 2).get(0).getText();
    }

    public String getArrivalAirport() {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 2).get(1).getText();
    }

    public String getSecondDepartureAirport() {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 5).get(3).getText();
    }

    public String getSecondArrivalAirport() {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 5).get(4).getText();
    }

    public String getName() {
        return baseFunc.waitForNumberOfElementsToBe(FLIGHT_INFO, 5).get(3).getText();
    }
}
