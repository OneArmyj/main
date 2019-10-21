package seedu.planner.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.planner.model.Model;
import seedu.planner.model.Planner;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setPlanner(new Planner());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
