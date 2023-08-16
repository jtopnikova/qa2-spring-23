package model;

public class Car {
    private String brand;
    private float engine;
    private String fuelType;
    private Long price;
    private Boolean isUsed;
    private int year;
    private String gearBox;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public void printCarInfo() {
        System.out.println(brand + " " + year + " " + price);
    }

    public void isItUsed() {
        if (isUsed = true) {
            System.out.println("This car is not new");
        } else {
            System.out.println("This car is brand new");
        }
    }
    //new comment
}

