package model;

public class Training {
    private String trainersName;
    private String type;
    private Integer durationInMinutes;
    private Boolean online;
    private boolean specialGearRequired;
    private String roomNumber;
    private String date;

    public String getTrainersName() {
        return trainersName;
    }

    public void setTrainersName(String trainersName) {
        this.trainersName = trainersName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public boolean isSpecialGearRequired() {
        return specialGearRequired;
    }

    public void setSpecialGearRequired(boolean specialGearRequired) {
        this.specialGearRequired = specialGearRequired;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void printTrainingType() {
        System.out.println(type + " " + "This training takes" + " " + durationInMinutes + " " + "minutes to complete");
    }
    public void printTrainingLocation() {
        System.out.println("This training takes place in room Nr" + " " + roomNumber);
    }
}
