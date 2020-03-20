package seedu.command.event;

import seedu.command.Command;
import seedu.event.Event;
import seedu.event.Task;
import seedu.event.TaskList;
import seedu.exception.DukeException;

public class EditVenue extends Command {
    private Integer index;
    private TaskList taskList;
    private String venue;

    public EditVenue(Integer index, String venue, TaskList taskList) {
        this.index = index - 1;
        this.venue = venue;
        this.taskList = taskList;
    }

    @Override
    public void execute() throws DukeException {
        taskList.editVenue(index, venue);
        System.out.println(taskList.list.get(index));
    }
}
