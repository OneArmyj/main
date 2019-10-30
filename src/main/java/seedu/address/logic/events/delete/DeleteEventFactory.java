package seedu.address.logic.events.delete;

import seedu.address.logic.commands.DeleteAccommodationCommand;
import seedu.address.logic.commands.DeleteActivityCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.events.Event;
import seedu.address.logic.events.exceptions.EventException;
import seedu.address.model.contact.Contact;
import seedu.address.model.itineraryitem.accommodation.Accommodation;
import seedu.address.model.itineraryitem.activity.Activity;

/**
 * A factory class to generate the corresponding delete Events according to the delete Commands parsed.
 */
public class DeleteEventFactory {
    public static final String MESSAGE_NOT_UNDOABLE = "The following command \'%1$s\' \'%2$s\' is not undoable";

    /**
     * A static method to generate the delete events based on the delete commands parsed.
     * @param command Delete Command to be parsed.
     * @return Corresponding event representing the delete command parsed.
     * @throws EventException
     */
    public static Event parse(DeleteCommand command) throws EventException {
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
            throw new EventException(
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
