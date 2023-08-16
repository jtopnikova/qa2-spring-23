package model;

public class Song {
    private String name;
    private String artist;
    private String length;
    private Integer monthlyListeners;
    private String genre;
    private Boolean grammyWon;
    private String releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getMonthlyListeners() {
        return monthlyListeners;
    }

    public void setMonthlyListeners(Integer monthlyListeners) {
        this.monthlyListeners = monthlyListeners;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getGrammyWon() {
        return grammyWon;
    }

    public void setGrammyWon(Boolean grammyWon) {
        this.grammyWon = grammyWon;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void printSongInfo() {
        System.out.println(artist + " " + name);
    }
    public void printAmountOfMonthlyListeners() {
        System.out.println(monthlyListeners);
    }
}
