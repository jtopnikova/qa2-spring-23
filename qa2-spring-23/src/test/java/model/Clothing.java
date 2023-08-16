package model;

public class Clothing {
    private String type;
    private Integer price;
    private String size;
    private String color;
    private String composition;
    private Boolean machineWash;
    private String brand;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Boolean getMachineWash() {
        return machineWash;
    }

    public void setMachineWash(Boolean machineWash) {
        this.machineWash = machineWash;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

    public void printItemInfo() {
        System.out.println(brand + " " + composition);
    }

    public void isMachineWashAllowed() {
        if (machineWash = true) {
            System.out.println("Machine wash");
        } else {
            System.out.println("Hand wash");
        }
    }
}
