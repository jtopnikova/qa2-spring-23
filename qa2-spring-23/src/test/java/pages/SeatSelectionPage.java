package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class SeatSelectionPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By BOOK_BTN = By.id("book3");
    private final By SELECTED_SEAT = By.xpath(".//div[@class = 'line']");
    private BaseFunc baseFunc;
    private int seatNr = 28;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat(int seatNr) {
        //wait for seats to appear
        baseFunc.waitForElementCountToBeAtLeast(SEAT, 15);
        //get all seats
        List<WebElement> seats = baseFunc.findElements(SEAT);
        Assertions.assertFalse(seats.isEmpty(), "No seats");
        //find necessary seat
        boolean isSeatFound = false; //flag is down
        for (WebElement seat : seats) {
            if (Integer.parseInt(seat.getText()) == seatNr) {
                seat.click();
                isSeatFound = true; //flag is up
                break;
            }
        }
        Assertions.assertTrue(isSeatFound, "Seat " + seatNr + "not found");
    }

    public void clickBook() {
        baseFunc.click(BOOK_BTN);
    }

    public String getSelectedSeat() {
     return baseFunc.findElement(SELECTED_SEAT).getText().substring(14);
    }
}
//__________FOR________
//  for (int i = 0; i < seats.size(); i = i + 1) {  //i = i + 1 => i++
//     System.out.println(seats.get(i).getText());

// ___FOR EACH___
//  for (WebElement seat : seats) {
//      System.out.println(seat.getText());

