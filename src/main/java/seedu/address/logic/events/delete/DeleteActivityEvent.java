package seedu.address.logic.events.add;

import seedu.address.logic.commands.AddActivityCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteActivityCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.itineraryitem.activity.Activity;

public class DeleteActivityEvent implements Event {
    private final Activity activityAdded;

    public AddActivityEvent(Activity activityAdded) {
        this.activityAdded = activityAdded;
    }

    public Command undo() {
        return new DeleteActivityCommand(activityAdded);
    }

    public Command redo() {
        return new AddActivityCommand(activityAdded);
    }
}