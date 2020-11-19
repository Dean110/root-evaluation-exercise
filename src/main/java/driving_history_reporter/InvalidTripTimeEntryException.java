package driving_history_reporter;

import java.text.ParseException;

public class InvalidTripTimeEntryException extends RuntimeException {
    public InvalidTripTimeEntryException(String message, Throwable e) {
        super(message, e);
    }
}
