package seedu.event;

import seedu.exception.DukeException;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTime {
    private String dateTime;
    private String dateTimeFormat;

    public DateTime(String arguments) throws DukeException {
            this.dateTime = arguments;
            this.dateTimeFormat = getDateTimeFormat();;
    }

    public String getDateTimeFormat() throws DukeException {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
            return localDateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy HHmm"));
        } catch (DateTimeParseException e){
            throw new DukeException("Please provide the correct format");
        }
    }

    public String toString() {
        return this.dateTimeFormat;
    }

}