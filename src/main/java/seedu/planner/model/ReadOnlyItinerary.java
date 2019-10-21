package seedu.planner.model;

import javafx.collections.ObservableList;
import seedu.planner.model.day.Day;

/**
 * Unmodifiable view of an Itinerary
 */
public interface ReadOnlyItinerary {

    /**
     * Returns an unmodifiable view of the itinerary.
     * This list will not contain any duplicate days.
     */
    ObservableList<Day> getItinerary();

}
