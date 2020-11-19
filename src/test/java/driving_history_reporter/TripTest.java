package driving_history_reporter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TripTest {

    private Driver testDriver;
    private Trip underTest;

    @BeforeEach
    void setUp() {
        testDriver = new Driver("Test Driver");
    }

    @Test
    public void tripWithOneHourOfTravelingShouldReportOneHourTraveled(){
        underTest = new Trip(testDriver, "12:00", "13:00", 20.0);
        double tripElapsedTime = underTest.calculateElapsedTime();
        assertThat(tripElapsedTime).isEqualTo(1.0, offset(.01));
    }

    @Test
    public void tripWithTwoHoursOfTravelTimeShouldReturnTwoHours(){
        underTest = new Trip(testDriver, "12:00", "14:00", 40.0);
        double tripElapsedTime = underTest.calculateElapsedTime();
        assertThat(tripElapsedTime).isEqualTo(2.0, offset(.01));
    }
    @Test
    public void tripWithHalfHourOfTravelShouldReturnHalfHour(){
        underTest = new Trip(testDriver, "12:00", "12:30", 40.0);
        double tripElapsedTime = underTest.calculateElapsedTime();
        assertThat(tripElapsedTime).isEqualTo(.5, offset(.01));
    }
    @Test
    public void calculateElapsedTimeWillThrowAnExceptionIfGivenAStringThatCannotBeParsed(){
        underTest = new Trip(testDriver, "foo", "12:30", 40.0);
        assertThrows(InvalidTripTimeEntryException.class, ()->underTest.calculateElapsedTime());
    }
}