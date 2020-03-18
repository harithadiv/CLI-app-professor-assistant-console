package seedu.event;

import seedu.exception.DukeException;
import seedu.ui.UI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventList {
    public ArrayList<Event> list;

    /**
     * Empty constructor. Creates an empty list.
     */
    public EventList() {
        this.list = new ArrayList<>();
    }

    /**
     * Add the specified event to the end of list.
     * @param event the event to be appended
     */
    public void add(Event event) {
        list.add(event);
        if (event instanceof Seminar) {
            UI.addSeminarMessage("Seminar", event.getName());
        } else {
            UI.addEventMessage("Event", event.getName());
        }
    }

    /**
     * Delete the first instance of the specified event in the list.
     * Returns {@code true} if the specified event is found (and removed)
     * from the list.
     * @param event the event to be deleted
     * @return {@code true} if the specified event is found (and removed)
     *      from the list
     */
    public boolean delete(Event event) {
        return list.remove(event);
    }

    /**
     * Removes the event at the specified position in this list.
     * Shifts any subsequent events to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the removed event
     */
    public void delete(int index) throws DukeException {
        if (index >= list.size()) {
            throw new DukeException("Index not found.");
        }
        if (list.get(index) instanceof Seminar){
            UI.deleteEventMessage("Seminar", list.get(index).getName());
        } else {
            UI.deleteEventMessage("Event", list.get(index).getName());
        }
        list.remove(index);
    }

    /**
     * Returns the event at the specified position in this list.
     * @param index index of the event to find
     * @return the event in the specified position
     */
    public Event find(int index) throws DukeException {
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
        Event event = this.find(index);
        if (event instanceof Seminar) {
            UI.editSeminarNameMessage(event.getName(), name);
        } else {
            UI.editEventNameMessage(event.getName(), name);
        }
        event.setName(name);
    }

    /**
     * Change the datetime of the event in the specified index.
     * @param index index of the event
     * @param datetime new datetime for the event
     */
    public void editDatetime(int index, String datetime) throws DukeException {
        Event event = this.find(index);
        event.setDatetime(datetime);
    }

    /**
     * Change the venue of the event in the specified index.
     * @param index index of the event
     * @param venue new venue for the event
     */
    public void editVenue(int index, String venue) throws DukeException {
        Event event = this.find(index);
        event.setVenue(venue);
    }

    public void editEvent(int index, Event event) throws DukeException {
        if (index >= list.size()) {
            throw new DukeException("Index not found.");
        }
        if (event instanceof Seminar) {
            UI.editSeminarMessage(list.get(index), event);
        } else {
            UI.editEventMessage(list.get(index), event);
        }
        list.remove(index);
        list.add(index, event);
    }

    public int getSize() {
        return list.size();
    }

    public void listEvent() throws DukeException {
        if (list.size() == 0) {
            throw new DukeException("List is empty");
        }
        UI.printEventList(list);
    }

    public void listSeminar() throws DukeException {
        if (list.size() == 0){
            throw new DukeException("List is empty");
        }
        ArrayList<Event> seminarList = new ArrayList<>();
        for (Event item : list) {
            if (item instanceof Seminar){
                seminarList.add(item);
            }
        }
        UI.printSeminarList(seminarList);
    }
}
