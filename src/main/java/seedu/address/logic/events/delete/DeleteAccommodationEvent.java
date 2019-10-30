package seedu.address.logic.events.delete;

import seedu.address.logic.commands.AddAccommodationCommand;
import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.itineraryitem.accommodation.Accommodation;

/**
 * An event representing a 'delete accommodation' command.
 */
public class DeleteAccommodationEvent implements Event {
    private final Accommodation accommodationDeleted;

    public DeleteAccommodationEvent(Accommodation accommodationDeleted) {
        this.accommodationDeleted = accommodationDeleted;
    }

    public UndoableCommand undo() {
        return new AddAccommodationCommand(accommodationDeleted);
    }

    public UndoableCommand redo() {
        return new DeleteAccommodationCommand(accommodationDeleted);
    }
}
