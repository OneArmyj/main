package seedu.address.logic.events;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.InitCommand;
import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.events.add.AddEventFactory;
import seedu.address.logic.events.delete.DeleteEventFactory;
import seedu.address.logic.events.edit.EditEventFactory;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class EventFactory {
    public static Event parse(UndoableCommand command, Model model) throws CommandException {
        requireNonNull(command);
        requireNonNull(model);

        String commandWord = command.getCommandWord();

        switch(commandWord) {
        case (AddCommand.COMMAND_WORD):
            AddEventFactory.parse((AddCommand)command);

        case (DeleteCommand.COMMAND_WORD):
            DeleteEventFactory.parse((DeleteCommand)command);

        case (EditCommand.COMMAND_WORD):
            EditEventFactory.parse((EditCommand)command, model);

        case (ClearCommand.COMMAND_WORD):
            parseClearCommand(command);
            
        case (InitCommand.COMMAND_WORD):
            parseInitCommand(command);
    }
}