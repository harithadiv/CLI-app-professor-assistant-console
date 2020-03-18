package seedu.command.event;

import seedu.command.Command;
import seedu.event.EventList;
import seedu.exception.DukeException;

public class ListSeminar extends Command {
    private EventList eventList;

    public ListSeminar(EventList eventList){
        this.eventList = eventList;
    }

    @Override
    public void execute() throws DukeException {
        eventList.listSeminar();
    }
}
