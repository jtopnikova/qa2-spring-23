package model;

import java.math.BigDecimal;

public class Product {
    private String category;
    private BigDecimal price;
    private String productCode;
    private int count;
    private String color;
    private String brand;
    private boolean inStock;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void printItemDescription() {
        System.out.println(brand + " " + category + " " + color);
    }
    public void isItInStock() {
        if (inStock = true) {
            System.out.println("This car is available");
        } else {
            System.out.println("This car is out of stock");
        }
    }

}
