package seedu.command.event;

import seedu.command.Command;
import seedu.event.TaskList;
import seedu.exception.DukeException;


public class DeleteEvent extends Command {
    private Integer index;
    private TaskList taskList;

    public DeleteEvent(Integer index, TaskList taskList) {
        this.index = index - 1;
        this.taskList =  taskList;
    }

    @Override
    public void execute() throws DukeException {
        taskList.delete(index);
    }
}
