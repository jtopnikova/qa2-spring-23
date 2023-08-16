package model;

public class Country {
    private String name;
    private Long population;
    private String capital;
    private String officialLanguage;
    private Double totalAreaInKmSq;
    private String currency;
    private Boolean rightHandTraffic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }

    public void setOfficialLanguage(String officialLanguage) {
        this.officialLanguage = officialLanguage;
    }

    public Double getTotalAreaInKmSq() {
        return totalAreaInKmSq;
    }

    public void setTotalAreaInKmSq(Double totalAreaInKmSq) {
        this.totalAreaInKmSq = totalAreaInKmSq;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getRightHandTraffic() {
        return rightHandTraffic;
    }

    public void setRightHandTraffic(Boolean rightHandTraffic) {
        this.rightHandTraffic = rightHandTraffic;
    }
    public void printNameAndCapital() {
        System.out.println(name + " " + capital);
    }
    public void printOfficialLanguage() {
        System.out.println(officialLanguage);
    }
}
