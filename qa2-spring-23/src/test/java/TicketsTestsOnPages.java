import pages.*;
import model.ReservationInfo;
import org.junit.jupiter.api.Test;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE = "RIX";
    private final String ARRIVAL = "MEL";
    private ReservationInfo info = new ReservationInfo("Julija", "Tester", "WERTR", 4,
            1, 1, "11-05-2018");
    private int seatNr = 28;


    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(DEPARTURE);
        homePage.selectArrivalAirport(ARRIVAL);
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);
        infoPage.clickGetPrice();
        infoPage.clickBook();

        //SeatingChartPage seatsPage = new SeatingChartPage(baseFunc);
        //seatsPage.chooseSeat();
        //seatsPage.clickBook();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(seatNr);
        seatSelectionPage.clickBook();

        FinalPage finalPage = new FinalPage(baseFunc);
        finalPage.testIfReservationSuccessfull();
    }
}
