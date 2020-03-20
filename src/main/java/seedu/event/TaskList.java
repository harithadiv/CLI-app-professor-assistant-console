package seedu.event;

import seedu.exception.DukeException;
import seedu.ui.UI;

import java.util.ArrayList;


public class TaskList {
    public ArrayList<Task> list;

    /**
     * Empty constructor. Creates an empty list.
     */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Add the specified event to the end of list.
     * @param task the task to be appended
     */
    public void add(Task task) {
        list.add(task);
        if (task instanceof Seminar) {
            UI.addTaskMessage("Seminar", task.getName());
        } else {
            UI.addTaskMessage("Event", task.getName());
        }
    }

    /**
     * Delete the first instance of the specified event in the list.
     * Returns {@code true} if the specified event is found (and removed)
     * from the list.
     * @param task the task to be deleted
     * @return {@code true} if the specified event is found (and removed)
     *      from the list
     */
    public boolean delete(Task task) {
        return list.remove(task);
    }

    /**
     * Removes the event at the specified position in this list.
     * Shifts any subsequent events to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index) throws DukeException {
        if (list.size() == 0) {
            throw new DukeException("List is empty, unable to delete any items.");
        } else if (index >= list.size()) {
            throw new DukeException("Index not found.");
        }
        if (list.get(index) instanceof Seminar) {
            UI.deleteTaskMessage("Seminar", list.get(index).getName());
        } else {
            UI.deleteTaskMessage("Event", list.get(index).getName());
        }
        list.remove(index);
    }

    /**
     * Returns the event at the specified position in this list.
     * @param index index of the event to find.
     * @return the event in the specified position.
     * @throws DukeException If list is empty.
     */
    public Task find(int index) throws DukeException {
        if (index >= list.size()) {
            throw new DukeException("Index not found.");
        }
        return list.get(index);
    }

    /**
     * Change the name of the event in the specified index.
     * @param index index of the event
     * @param name new name for the event
     */
    public void editName(int index, String name) throws DukeException {
        Task task = this.find(index);
        if (task instanceof Seminar) {
            UI.editTaskNameMessage(task.getName(), name, "Seminar");
        } else {
            UI.editTaskNameMessage(task.getName(), name, "Event");
        }
        task.setName(name);
    }

    /**
     * Change the datetime of the event in the specified index.
     * @param index index of the event
     * @param datetime new datetime for the event
     */
    public void editDatetime(int index, String datetime) throws DukeException {
        Task task = this.find(index);
        if (task instanceof Seminar) {
            UI.editTaskDateTimeMessage(task.getDatetime(), datetime, "Seminar");
        } else {
            UI.editTaskDateTimeMessage(task.getDatetime(), datetime, "Event");
        }
        task.setDatetime(datetime);
    }

    /**
     * Change the venue of the event in the specified index.
     * @param index index of the event
     * @param venue new venue for the event
     */
    public void editVenue(int index, String venue) throws DukeException {
        Task task = this.find(index);
        if (task instanceof Seminar) {
            UI.editTaskVenueMessage(task.getVenue(), venue, "Seminar");
        } else {
            UI.editTaskVenueMessage(task.getVenue(), venue, "Event");
        }
        task.setVenue(venue);
    }

    /**
     * Edits all the fields in the event, ie. name, date and time, venue.
     *
     * @param index Index of the event to be edited.
     * @param task New task that user inputs.
     * @throws DukeException If list is empty.
     */
    public void editEvent(int index, Task task) throws DukeException {
        if (index >= list.size()) {
            throw new DukeException("Index not found.");
        }
        if (task instanceof Seminar) {
            UI.editTaskMessage(list.get(index).toString(), task.toString(), "Seminar");
        } else {
            UI.editTaskMessage(list.get(index).toString(), task.toString(), "Event");
        }
        list.remove(index);
        list.add(index, task);
    }

    public int getSize() {
        return list.size();
    }

    /**
     * Lists all types of events.
     *
     * @throws DukeException If list is empty.
     */
    public void listEvent() throws DukeException {
        if (list.size() == 0) {
            throw new DukeException("List is empty");
        }
        UI.printTaskList(list);
    }

    /**
     * Lists out events that are of seminar type only.
     *
     * @throws DukeException If list is empty.
     */
    public void listSeminar() throws DukeException {
        if (list.size() == 0) {
            throw new DukeException("List is empty");
        }
        ArrayList<Task> seminarList = new ArrayList<>();
        for (Task task : list) {
            if (task instanceof Seminar) {
                seminarList.add(task);
            }
        }
        UI.printSeminarList(seminarList);
    }
}
