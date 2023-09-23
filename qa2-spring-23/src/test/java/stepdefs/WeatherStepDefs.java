package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import model.weather.Weather;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city ID is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude) {
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect latitude!");
    }

    @Then("longitude is {double}")
    public void longitude_check(double longitude) {
        Assertions.assertEquals(longitude, response.getLon(), "Incorrect longitude!");
    }

    @Then("timezone is {string}")
    public void timezone_check(String timezone) {
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect timezone!");
    }

    @Then("timezone offset is {int}")
    public void timezone_offset_check(int offset) {
        Assertions.assertEquals(offset, response.getTimezoneOffset(), "Incorrect offset!");
    }

    @Then("current weather data is:")
    public void current_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect DT!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect sunrise");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect sunset");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels like")), response.getCurrent().getFeelsLike(),"Incorrect feels like");
        Assertions.assertEquals(Double.parseDouble(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect pressure");
        Assertions.assertEquals(Double.parseDouble(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew point")), response.getCurrent().getDewPoint(), "Incorrect dew point");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect UVI");
        Assertions.assertEquals(Double.parseDouble(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect clouds");
        Assertions.assertEquals(Double.parseDouble(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect visibility");
        Assertions.assertEquals(Double.parseDouble(params.get("wind speed")), response.getCurrent().getWindSpeed(), "Incorrect wind speed");
        Assertions.assertEquals(Double.parseDouble(params.get("wind deg")), response.getCurrent().getWindDeg(), "Incorrect wind deg");
        Assertions.assertEquals(Double.parseDouble(params.get("wind gust")), response.getCurrent().getWindGust(), "Incorrect wind gust");
    }

    @Then("current weather details are:")
    public void current_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect current weather id");
        Assertions.assertEquals("main", response.getCurrent().getWeathers().get(0).getMain(), "Incorrect current weather main");
        Assertions.assertEquals("description", response.getCurrent().getWeathers().get(0).getDescription());
   Assertions.assertEquals("icon", response.getCurrent().getWeathers().get(0).getIcon(), "Incorrect current weather icon");
    }

    @Then("minutely details are:")
    public void minutely_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutely().get(0).getDt(), "Incorrect minutely dt");
        Assertions.assertEquals(Double.parseDouble(params.get("precipitation")), response.getMinutely().get(0).getPrecipitation(), "Incorrect minutely precipitation");
    }

    @Then("hourly details are:")
    public void hourly_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourly().get(0).getDt(), "Incorrect hourly dt");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourly().get(0).getTemp(), "Incorrect hourly temp");
        Assertions.assertEquals(Double.parseDouble(params.get("feels like")), response.getHourly().get(0).getFeelsLike(), "Incorrect hourly feels like");
        Assertions.assertEquals(Double.parseDouble(params.get("pressure")), response.getHourly().get(0).getPressure(), "Incorrect hourly pressure");
        Assertions.assertEquals(Double.parseDouble(params.get("humidity")), response.getHourly().get(0).getHumidity(), "Incorrect hourly humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew point")), response.getHourly().get(0).getDewPoint(), "Incorrect hourly dew point");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourly().get(0).getUvi(), "Incorrect hourly uvi");
        Assertions.assertEquals(Double.parseDouble(params.get("clouds")), response.getHourly().get(0).getClouds(), "Incorrect hourly clouds");
        Assertions.assertEquals(Double.parseDouble(params.get("visibility")), response.getHourly().get(0).getVisibility(), "Incorrect hourly visibility");
    }

    @Then("hourly weather details are:")
    public void hourly_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getHourly().get(0).getWeathers().get(0).getId());
    }

    @Then("daily details are:")
    public void daily_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDaily().get(0).getDt());
    }

    @Then("daily feels temp like details are:")
    public void daily_feels_like_details_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDaily().get(0).getFeelsLike().getDay());
    }

    @Then("daily weather details are:")
    public void daily_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getDaily().get(0).getWeathers().get(0).getId());
    }

    @Then("alerts are:")
    public void alerts_check(Map<String, String> params) {
        Assertions.assertEquals("senders name", response.getAlerts().get(0).getSenderName());
    }
}
