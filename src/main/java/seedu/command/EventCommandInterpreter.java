package seedu.command;

import seedu.command.event.AddEvent;
import seedu.command.event.EditDateTime;
import seedu.command.event.EditName;
import seedu.command.event.EditVenue;
import seedu.command.event.EditEvent;
import seedu.command.event.DeleteEvent;
import seedu.command.event.ListEvent;
import seedu.exception.DukeException;
import seedu.event.Event;
import seedu.event.TaskList;
import seedu.parser.TaskParser;

public class EventCommandInterpreter extends CommandInterpreter {
    protected TaskParser taskParser;

    public EventCommandInterpreter(TaskList taskList) {
        super(taskList);
        this.taskParser = new TaskParser();
    }

    @Override
    public Command decideCommand(String commandDescription) throws DukeException {
        Command command = null;
        Event event;
        int index;
        String name;
        String datetime;
        String venue;

        String commandType = getFirstWord(commandDescription);
        String commandParameters = getSubsequentWords(commandDescription);
        assert commandType == " " : "Event: Unknown command";
        assert commandType == " " : "Event: Command is null";
        switch (commandType) {
        case "add":
            event = taskParser.parseEvent(commandParameters);
            command = new AddEvent(event, this.taskList);
            break;
        case "editname":
            index = taskParser.parseIndex(commandParameters);
            name = taskParser.parseEventName(commandParameters);
            command = new EditName(index, name, this.taskList);
            break;
        case "editdatetime":
            index = taskParser.parseIndex(commandParameters);
            datetime = taskParser.parseEventDateTime(commandParameters);
            command = new EditDateTime(index, datetime, this.taskList);
            break;
        case "editvenue":
            index = taskParser.parseIndex(commandParameters);
            venue = taskParser.parseVenue(commandParameters);
            command = new EditVenue(index, venue, this.taskList);
            break;
        case "editevent":
            index = taskParser.parseIndex(commandParameters);
            event = taskParser.parseEvent(commandParameters);
            command = new EditEvent(index, event, this.taskList);
            break;
        case "delete":
            index = taskParser.parseIndex(commandParameters);
            command = new DeleteEvent(index, this.taskList);
            break;
        case "list":
            command = new ListEvent(this.taskList);
            break;
        default:
            throw new DukeException("Event: Unknown command");
        }

        if (command == null) {
            throw new DukeException("Event: Command is null");
        }
        return command;
    }
}
