package model;

public class Pet {
    private String type;
    private Integer age;
    private Boolean isChipped;
    private String name;
    private String breed;
    private Double weightInKg;
    private String color;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getChipped() {
        return isChipped;
    }

    public void setChipped(Boolean chipped) {
        isChipped = chipped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void printPetDescription() {
        System.out.print(type + " " + breed + " " + color);
    }
    public void isPetOverweight() {
        if (weightInKg>5) {
            System.out.println("Pet is Overweight");
        } else {
            System.out.println("Pet is healthy");
        }
    }

}
