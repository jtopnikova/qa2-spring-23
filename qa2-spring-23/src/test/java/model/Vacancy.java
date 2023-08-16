package model;

public class Vacancy {
    private String position;
    private String seniorityLevel;
    private Boolean isFullTime;
    private String schedule;
    private Integer salary;
    private String companyName;
    private String recruiter;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public Boolean getFullTime() {
        return isFullTime;
    }

    public void setFullTime(Boolean fullTime) {
        isFullTime = fullTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter;
    }

    public void printPositionInfo() {
        System.out.println(position + " " + seniorityLevel);
    }

    public void isThisPositionFullTime() {
        if (isFullTime = true) {
            System.out.println("This position is full time");
        } else {
            System.out.println("This position is part time");
        }
    }
}
