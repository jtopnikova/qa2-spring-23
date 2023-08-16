package model;

import java.math.BigDecimal;

public class Trip {
    private String destination;
    private Integer numberOfPeople;
    private BigDecimal pricePerPerson;
    private boolean covidCertificateRequired;
    private Boolean visaRequired;
    private Double hotelRating;
    private int nightsInHotel;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public BigDecimal getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(BigDecimal pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public boolean isCovidCertificateRequired() {
        return covidCertificateRequired;
    }

    public void setCovidCertificateRequired(boolean covidCertificateRequired) {
        this.covidCertificateRequired = covidCertificateRequired;
    }

    public Boolean getVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(Boolean visaRequired) {
        this.visaRequired = visaRequired;
    }

    public Double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Double hotelRating) {
        this.hotelRating = hotelRating;
    }

    public int getNightsInHotel() {
        return nightsInHotel;
    }

    public void setNightsInHotel(int nightsInHotel) {
        this.nightsInHotel = nightsInHotel;
    }
//    public void printTotalPrice() {
//        System.out.println(pricePerPerson*numberOfPeople);
//    }
    public void printPrice() {
        System.out.println("This trip costs" + " " + pricePerPerson + " " + "EUR per person");
    }
}
