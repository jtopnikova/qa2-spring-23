package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import model.Tickets.Flight;
import model.Tickets.Passenger;
import model.Tickets.Reservation;
import org.junit.jupiter.api.Assertions;
import pages.*;
import requesters.TicketsRequester;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatSelectionPage seatSelectionPage;
    private FinalPage finalPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

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
    public void selected_airport_check() {
        Assertions.assertEquals(flight.getDeparture(), infoPage.getDepartureAirport(), "Incorrect departure airport");
        Assertions.assertEquals(flight.getArrival(), infoPage.getArrivalAirport(), "Incorrect arrival airport");
    }

    @When("we are filling in passenger info and requesting price")
    public void fill_in_flight_info() {
        infoPage.fillInPassengerInfo(passenger, flight);
        infoPage.clickGetPrice();
    }

    @Then("airports and price appear in flight details")
    public void airports_and_price_check() {
        Assertions.assertEquals(flight.getDeparture(), infoPage.getSecondDepartureAirport(), "Incorrect departure(2) airport");
        Assertions.assertEquals(flight.getArrival(), infoPage.getSecondArrivalAirport(), "Incorrect arrival(2) airport");
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
        Assertions.assertEquals(String.valueOf(flight.getSeatNr()), seatSelectionPage.getSelectedSeat(), "Incorrect Seat Number");
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
    @When("we are requesting all reservations via API")
    public void request_all_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation exists in the list")
    public void find_reservation() {
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(passenger.getFirstName())) {
                reservationFromApi = reservation;
                break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "Cant find reservation");
    }

    @And("all data is stored correctly")
    public void check_reservation_data() {
        Assertions.assertEquals(passenger.getFirstName(), reservationFromApi.getName(), "Wrong name");
        Assertions.assertEquals(passenger.getLastName(), reservationFromApi.getSurname(), "Wrong last name");
        Assertions.assertEquals(flight.getSeatNr(), reservationFromApi.getSeat(), "Wrong seat number");
        Assertions.assertEquals(flight.getDiscount(), reservationFromApi.getDiscount(), "Wrong discount");
        Assertions.assertEquals(flight.getPassengersCount(), reservationFromApi.getAdults(), "Wrong passengers count");
        Assertions.assertEquals(flight.getChildCount(), reservationFromApi.getChildren(), "Wrong children count");
        Assertions.assertEquals(flight.getLuggageCount(), reservationFromApi.getBugs(), "Wrong luggage count");
        Assertions.assertEquals(flight.getFlightDate().substring(0, 2), reservationFromApi.getFlight(), "Wrong flight date");
        Assertions.assertEquals(flight.getSeatNr(), reservationFromApi.getSeat(), "Wrong sear number");
    }
}
