package seedu.address.logic.events.delete;

import seedu.address.logic.commands.AddActivityCommand;
import seedu.address.logic.commands.DeleteActivityCommand;
import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.itineraryitem.activity.Activity;

public class DeleteActivityEvent implements Event {
    private final Activity activityDeleted;

    public DeleteActivityEvent(Activity activityDeleted) {
        this.activityDeleted = activityDeleted;
    }

    public UndoableCommand undo() {
        return new AddActivityCommand(activityDeleted);
    }

    public UndoableCommand redo() {
        return new DeleteActivityCommand(activityDeleted);
    }
}