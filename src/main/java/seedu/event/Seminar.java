package seedu.event;

import seedu.exception.DukeException;

import java.security.InvalidParameterException;
import java.time.Instant;

public class Seminar extends Event {

    public Seminar(String name, String datetime, String venue) throws DukeException {
        super(name, datetime, venue);
    }

    @Override
    public void setName(String name) throws DukeException {
        if (this.name == null || this.name.isEmpty()) {
            // if original name is empty or null
            if (name == null || name.isEmpty()) {
                // if new name is empty or null
                this.name = "seminar_" + Instant.now().getEpochSecond();
            } else {
                this.name = name;
            }
        } else {
            // if original name is not empty and null
            if (name == null || name.isEmpty()) {
                // if new name is empty or null
                throw new DukeException("Empty name");
            } else {
                // if new name is not empty and not null
                this.name = name;
            }
        }
    }

    @Override
    public String toString() {
        if (getDatetime().equals("yyyy-MM-dd HHmm") && getVenue().equals("")) {
            return "Seminar: " + getName();
        } else if (getVenue().equals("")) {
            return "Seminar: " + getName() + ", time: " + getDatetime();
        }
        return "Seminar: " + getName() + ", time: " + getDatetime() + ", venue: " + getVenue();
    }
}
