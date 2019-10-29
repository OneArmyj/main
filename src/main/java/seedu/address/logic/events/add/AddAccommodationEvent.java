package seedu.address.logic.events.add;

import seedu.address.logic.commands.AddAccommodationCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.itineraryitem.accommodation.Accommodation;

public class AddAccommodationEvent implements Event {
    private final Accommodation accommodationAdded;

    public AddAccommodationEvent(Accommodation accommodationAdded) {
        this.accommodationAdded = accommodationAdded;
    }

    public Command undo() {
        return new DeleteAccommodationCommand(accommodationAdded);
    }

    public Command redo() {
        return new AddAccommodationCommand(accommodationAdded);
    }
}