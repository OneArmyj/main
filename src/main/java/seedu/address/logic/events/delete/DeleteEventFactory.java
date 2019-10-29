package seedu.address.logic.events.delete;

import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.commands.DeleteActivityCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.events.Event;
import seedu.address.model.contact.Contact;
import seedu.address.model.itineraryitem.accommodation.Accommodation;
import seedu.address.model.itineraryitem.activity.Activity;

public class DeleteEventFactory {
    public static final String MESSAGE_NOT_UNDOABLE = "The following command \'%1$s\' \'%2$s\' is not undoable";

    public static Event parse(DeleteCommand command) throws CommandException {
        String secondCommandWord = command.getSecondCommandWord();

        switch(secondCommandWord) {
        case (DeleteAccommodationCommand.SECOND_COMMAND_WORD):
            DeleteAccommodationCommand tempCommand1 = (DeleteAccommodationCommand) command;
            return generateDeleteAccommodationEvent(tempCommand1.getToDelete());

        case (DeleteActivityCommand.SECOND_COMMAND_WORD):
            DeleteActivityCommand tempCommand2 = (DeleteActivityCommand) command;
            return generateDeleteActivityEvent(tempCommand2.getToDelete());

        case (DeleteContactCommand.SECOND_COMMAND_WORD):
            DeleteContactCommand tempCommand3 = (DeleteContactCommand) command;
            return generateDeleteContactEvent(tempCommand3.getToDelete());

        default:
            throw new CommandException(
                    String.format(MESSAGE_NOT_UNDOABLE, command.getCommandWord(), command.getSecondCommandWord())
            );
        }

        /*
        case(DeleteDayCommand.SECOND_COMMAND_WORD):
            DeleteDayCommand tempCommand4 = (DeleteDayCommand)command;
            generateDeleteDayEvent(tempCommand4.getToDelete());
        }
        */
    }

    public static DeleteAccommodationEvent generateDeleteAccommodationEvent(Accommodation accommodationDeleteed) {
        return new DeleteAccommodationEvent(accommodationDeleteed);
    }

    public static DeleteActivityEvent generateDeleteActivityEvent(Activity activityDeleteed) {
        return new DeleteActivityEvent(activityDeleteed);
    }

    public static DeleteContactEvent generateDeleteContactEvent(Contact contactDeleteed) {
        return new DeleteContactEvent(contactDeleteed);
    }

    /*
    public static DeleteDayEvent generateDeleteDayEvent(int daysDeleteed) {
        return new DeleteDayEvent(daysDeleteed);
    }
    */
}