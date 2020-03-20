package seedu.command.event;

import seedu.command.Command;
import seedu.event.Event;
import seedu.event.Task;
import seedu.event.TaskList;
import seedu.exception.DukeException;

public class ListEvent extends Command {
    private TaskList taskList;

    public ListEvent(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() throws DukeException {
        taskList.listEvent();
    }
}
