package driving_history_reporter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TripTest {

    private Driver testDriver;
    private Trip underTest;

    @BeforeEach
    void setUp() {
        testDriver = new Driver("Test Driver");

    }

    @Test
    public void tripWithOneHourOfTravelingShouldReportOneHourTraveled() {
        underTest = new Trip(testDriver, "12:00", "13:00", 20.0);
        double tripElapsedTime = underTest.calculateElapsedTime();
        assertThat(tripElapsedTime).isEqualTo(1.0, offset(.01d));
    }
}