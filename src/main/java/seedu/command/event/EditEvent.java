package seedu.command.event;

import seedu.command.Command;
import seedu.event.Event;
import seedu.event.Task;
import seedu.event.TaskList;
import seedu.exception.DukeException;

public class EditEvent extends Command {
    private Integer index;
    private Task newTask;
    private TaskList taskList;

    public EditEvent(Integer index, Task newTask, TaskList taskList) {
        this.index = index - 1;
        this.newTask = newTask;
        this.taskList = taskList;
    }

    @Override
    public void execute() throws DukeException {
        taskList.editEvent(index, newTask);
    }
}
