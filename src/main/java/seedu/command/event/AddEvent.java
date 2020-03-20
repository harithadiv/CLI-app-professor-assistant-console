package seedu.command.event;

import seedu.command.Command;
import seedu.event.Event;
import seedu.event.Task;
import seedu.event.TaskList;

public class AddEvent extends Command {
    private Task newTask;
    private TaskList taskList;

    public AddEvent(Task newTask, TaskList taskList) {
        this.newTask = newTask;
        this.taskList = taskList;
    }

    public AddEvent(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.add(newTask);
    }


}
