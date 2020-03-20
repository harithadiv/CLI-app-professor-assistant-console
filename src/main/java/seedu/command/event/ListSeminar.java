package seedu.command.event;

import seedu.command.Command;

import seedu.event.TaskList;
import seedu.exception.DukeException;

/** Only list out seminar. */
public class ListSeminar extends Command {
    private TaskList taskList;

    public ListSeminar(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() throws DukeException {
        taskList.listSeminar();
    }
}
