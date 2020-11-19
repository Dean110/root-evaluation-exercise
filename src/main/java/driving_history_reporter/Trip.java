package driving_history_reporter;

public class Trip {
    private Driver driver;
    private String startingTime;
    private String endingTime;
    private double milesDriven;

    public Trip(Driver driver, String startingTime, String endingTime, double milesDriven) {
        this.driver = driver;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.milesDriven = milesDriven;
    }

    public double calculateElapsedTime() {
        return 1;
    }
}
