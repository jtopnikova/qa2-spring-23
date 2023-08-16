package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FinalPage {
    private final By SUCCESS_MSG = By.xpath(".//div[@class=\"finalTxt\"]");

    private BaseFunc baseFunc;

    public FinalPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void testIfReservationSuccessfull() {
        WebElement successMsg = baseFunc.findElement(SUCCESS_MSG);
        Assertions.assertEquals("Thank You for flying with us!",successMsg.getText(), "Reservation unsuccessfull");
    }
}
