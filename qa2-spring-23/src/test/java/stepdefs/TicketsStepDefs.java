package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import model.Tickets.Flight;
import model.Tickets.Passenger;
import org.junit.jupiter.api.Assertions;
import pages.*;

import javax.swing.*;
import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatSelectionPage seatSelectionPage;
    private FinalPage finalPage;

    @Given("airports:")
    public void set_airports(Map<String, String> params) {
        flight.setDeparture(params.get("from"));
        flight.setArrival(params.get("to"));
    }

    @Given("passenger info is")
    public void set_passenger_info(Map<String, String> params) {
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
    }

    @Given("flight info is")
    public void set_flight_info(Map<String, String> params) {
        flight.setDiscount(params.get("discount"));
        flight.setPassengersCount(Integer.parseInt(params.get("passenger_count")));
        flight.setChildCount(Integer.parseInt(params.get("children_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNr(Integer.parseInt(params.get("seat_nr")));
    }

    @Given("home page is opened")
    public void open_home_page() {
        baseFunc.openUrl("qaguru.lv:8089/tickets");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appear on the passenger info page")
    public void selected_airport_check(Map<String, String> params) {
        Assertions.assertEquals(flight.getDeparture(), infoPage.getDepartureAirport(), "Incorrect departure airport");
        Assertions.assertEquals(flight.getArrival(), infoPage.getArrivalAirport(), "Incorrect arrival airport");
    }

    @When("we are filling in passenger info and requesting price")
    public void fill_in_flight_info(Map<String, String> params) {
        infoPage.fillInPassengerInfo(passenger, flight);
        infoPage.clickGetPrice();
    }

    @Then("airports and price appear in flight details")
    public void airports_and_price_check(Map<String, String> params) {
        Assertions.assertEquals(flight.getDeparture(), infoPage.getSecondDepartureAirport(), "Incorrect departure(2) airport");
        Assertions.assertEquals(flight.getDeparture(), infoPage.getSecondArrivalAirport(), "Incorrect arrival(2) airport");
    }

    @When("we are confirming price")
    public void confirm_price() {
        infoPage.clickBook();
    }

    @And("selecting seat number")
    public void select_seat() {
        seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(flight.getSeatNr());
    }

    @Then("selected seat number appears")
    public void selected_seat_check() {
        Assertions.assertEquals(flight.getSeatNr(), seatSelectionPage.getSelectedSeat(), "Incorrect Seat Number");
    }

    @When("we are confirming seat")
    public void confirm_seat() {
        seatSelectionPage.clickBook();
    }

    @Then("successful registration message appears")
    public void successful_registration_check() {
        finalPage = new FinalPage(baseFunc);
        finalPage.testIfReservationSuccessfull();
    }
}
