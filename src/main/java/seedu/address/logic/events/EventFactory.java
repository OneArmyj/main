package seedu.address.logic.events;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.InitCommand;
import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.events.add.AddEventFactory;
import seedu.address.logic.events.add.DeleteEventFactory;

public class EventFactory {
    public static Event parse(UndoableCommand command) throws CommandException {
        String commandWord = command.getCommandWord();

        switch(commandWord) {
        case (AddCommand.COMMAND_WORD):
            AddEventFactory.parse((AddCommand)command);

        case (DeleteCommand.COMMAND_WORD):
            DeleteEventFactory.parse(command);

        case (EditCommand.COMMAND_WORD):
            EditEventFactory.parse(command);

        case (ClearCommand.COMMAND_WORD):
            parseClearCommand(command);
            
        case (InitCommand.COMMAND_WORD):
            parseInitCommand(command);
    }
}