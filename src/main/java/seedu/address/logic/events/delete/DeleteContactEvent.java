package seedu.address.logic.events.add;

import seedu.address.logic.commands.AddContactCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.events.Event;
import seedu.address.model.contact.Contact;

public class DeleteContactEvent implements Event {
    private final Contact contactAdded;

    public AddContactEvent(Contact contactAdded) {
        this.contactAdded = contactAdded;
    }

    public Command undo() {
        return new DeleteContactCommand(contactAdded);
    }

    public Command redo() {
        return new AddContactCommand(contactAdded);
    }
}