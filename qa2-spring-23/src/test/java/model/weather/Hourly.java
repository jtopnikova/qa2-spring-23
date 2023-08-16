package model.weather;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hourly {
    private long dt;
    private double temp;

    @JsonProperty("feels_like")
    private double feelsLike;
    private double pressure;
    private double humidity;

    @JsonProperty("dew_point")
    private double dewPoint;
    private double uvi;
    private double clouds;
    private double visibility;

    @JsonProperty("wind_speed")
    private double windSpeed;

    @JsonProperty("wind_deg")
    private double windDeg;

    @JsonProperty("wind_gust")
    private double windGust;

    @JsonProperty("weather")
    private List<Weather> weathers;
    private double pop;
}
