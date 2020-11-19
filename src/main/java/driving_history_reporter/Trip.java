package driving_history_reporter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public double calculateElapsedTime(){
        Date startingTimeStamp = parseToDate(startingTime);
        Date endingTimeStamp = parseToDate(endingTime);
        return calculateDecimalHours(startingTimeStamp, endingTimeStamp);
    }

    private Date parseToDate(String time){
        DateFormat hourMinuteFormatter = new SimpleDateFormat("HH:mm");
        try {
            return hourMinuteFormatter.parse(time);
        } catch (ParseException e) {
            throw new InvalidTripTimeEntryException("The value \"" + time +"\" is not in a valid format.", e);
        }
    }

    private double calculateDecimalHours(Date startingTime, Date endingTime) {
        double elapsedMilliSeconds = endingTime.getTime() - startingTime.getTime();
        return convertToHours(elapsedMilliSeconds);
    }

    private double convertToHours(double milliSeconds) {
        return milliSeconds / 1000 / 60 / 60;
    }
}
