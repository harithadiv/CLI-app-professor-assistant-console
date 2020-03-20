package seedu.command.event;

import seedu.command.Command;
import seedu.event.Task;
import seedu.event.TaskList;
import seedu.exception.DukeException;

public class EditName extends Command {
    private Integer index;
    private TaskList taskList;
    private String name;

    public EditName(Integer index, String name, TaskList taskList) {
        this.index = index - 1;
        this.name = name;
        this.taskList = taskList;
    }


    @Override
    public void execute() throws DukeException {
        taskList.editName(index, name);
    }
}
