package seedu.address.logic.commands.system;

import seedu.address.logic.commands.UndoableCommand;
import seedu.address.logic.commands.result.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyItinerary;

public class SetItineraryCommand extends UndoableCommand {
    private final static String COMMAND_WORD = "setitinerary";
    private final static String MESSAGE_SUCCESS = "Autoschedule successfully undone.";
    private final ReadOnlyItinerary itinerary;

    public SetItineraryCommand(ReadOnlyItinerary itinerary) {
        this.itinerary = itinerary;
    }

    @Override
    public String getCommandWord() {
        return COMMAND_WORD;
    }

    @Override
    public CommandResult execute(Model model) {
        model.setItinerary(itinerary);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}