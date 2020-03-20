package seedu.command.event;

import seedu.command.Command;
import seedu.event.TaskList;
import seedu.exception.DukeException;

public class EditDateTime extends Command {
    private Integer index;
    private TaskList taskList;
    private String datetime;

    public EditDateTime(Integer index, String datetime, TaskList taskList) {
        this.index = index - 1;
        this.datetime = datetime;
        this.taskList = taskList;
    }


    @Override
    public void execute() throws DukeException {
        taskList.editDatetime(index, datetime);
        System.out.println(taskList.list.get(index));
    }
}
