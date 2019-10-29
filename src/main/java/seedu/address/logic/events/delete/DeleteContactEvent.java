package seedu.address.logic.events.delete;

import seedu.address.logic.commands.AddContactCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.contact.Contact;

public class DeleteContactEvent implements Event {
    private final Contact contactDeleted;

    public DeleteContactEvent(Contact contactDeleted) {
        this.contactDeleted = contactDeleted;
    }

    public UndoableCommand undo() {
        return new AddContactCommand(contactDeleted);
    }

    public UndoableCommand redo() {
        return new DeleteContactCommand(contactDeleted);
    }
}