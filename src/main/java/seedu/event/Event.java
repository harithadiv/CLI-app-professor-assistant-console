package seedu.event;

import seedu.duke.Duke;
import seedu.exception.DukeException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.time.Instant;

public class Event extends Task {

    /**
     * Empty constructor. Sets name as "unnamed"
     */
    public Event() throws DukeException {
        super();
    }

    /**
     * Constructor with name, datetime, venue provided.
     * @param name name of event
     * @param datetime datetime of event
     * @param venue venue of event
     */
    public Event(String name, String datetime, String venue) throws DukeException {
        super(name, datetime, venue);
    }


    @Override
    public String toString() {
        if (getDatetime().equals("yyyy-MM-dd HHmm") && getVenue().equals("")) {
            return "Event: " + getName();
        } else if (getVenue().equals("")) {
            return "Event: " + getName() + ", time: " + getDatetime();
        }
        return "Event: " + getName() + ", time: " + getDatetime() + ", venue: " + getVenue();
    }
}