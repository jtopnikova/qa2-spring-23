package pages;

import model.ReservationInfo;
import org.openqa.selenium.By;

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

    public void fillInPassengerInfo(ReservationInfo reservationInfo) {
    baseFunc.type(NAME_INPUT, reservationInfo.getFirstName());
    baseFunc.type(SURNAME_INPUT, reservationInfo.getLastName());
    baseFunc.type(DISCOUNT_INPUT, reservationInfo.getDiscount());
    baseFunc.type(ADULT_COUNT_INPUT, reservationInfo.getPassengerCount());
    baseFunc.type(CHILDREN_COUNT_INPUT, reservationInfo.getChildCount());
    baseFunc.type(BAGS_COUNT_INPUT, reservationInfo.getBagsCount());
    baseFunc.selectByText(SELECTED_FLIGHT, reservationInfo.getFlightDate());

    }
    public void clickGetPrice()  {
        baseFunc.click(GET_PRICE_LINK);
    }
    public void clickBook() {
        baseFunc.click(BOOK_BTN);
    }
}
