import model.Tickets.Flight;
import model.Tickets.Passenger;
import pages.*;
import org.junit.jupiter.api.Test;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private Passenger passenger = new Passenger("Julija", "Top");
    private Flight flight = new Flight("RIX", "JFC", "CCCCCC", 2, 1, 3, "12-05-2018 ", 17);

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(passenger, flight);
        infoPage.clickGetPrice();
        infoPage.clickBook();

        //SeatingChartPage seatsPage = new SeatingChartPage(baseFunc);
        //seatsPage.chooseSeat();
        //seatsPage.clickBook();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(flight.getSeatNr());
        seatSelectionPage.clickBook();

        FinalPage finalPage = new FinalPage(baseFunc);
        finalPage.testIfReservationSuccessfull();
    }
}
