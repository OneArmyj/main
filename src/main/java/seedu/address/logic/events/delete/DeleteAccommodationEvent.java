package seedu.address.logic.events.delete;

import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.itineraryitem.accommodation.Accommodation;

public class DeleteAccommodationEvent implements Event {
    private final Accommodation accommodationDeleted;

    public DeleteAccommodationEvent(Accommodation accommodationDeleted) {
        this.accommodationDeleted = accommodationDeleted;
    }

    public Command undo() {
        return new DeleteAccommodationCommand(accommodationDeleted);
    }

    public Command redo() {
        return new DeleteAccommodationCommand(accommodationDeleted);
    }
}