package model;

import java.math.BigDecimal;

public class House {
    private String address;
    private String city;
    private String district;
    private Long price;
    private int numberOfStories;
    private Integer numberOfBedrooms;
    private Long totalArea;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getNumberOfStories() {
        return numberOfStories;
    }

    public void setNumberOfStories(int numberOfStories) {
        this.numberOfStories = numberOfStories;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Long getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Long totalArea) {
        this.totalArea = totalArea;
    }

    public void printLocation() {
        System.out.print(address + " " + city);
    }

    public Long result;

    public void getPricePerSquareMeter() {
        result = price / totalArea;
    }

    public void printPricePerSquareMeter() {
        System.out.println(result);
    }


}
