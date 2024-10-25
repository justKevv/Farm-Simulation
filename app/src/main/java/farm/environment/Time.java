package farm.environment;

public class Time {
    private int day;

    public Time() {
        this.day = 0;
    }

    public void advanceDay() {
        day++;
        System.out.println("Day " + day + " has passed.");
    }

    public int getDay() {
        return day;
    }
}
