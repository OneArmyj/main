package seedu.planner.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.planner.model.Model.PREDICATE_SHOW_ALL_CONTACTS;

import seedu.planner.model.Model;

/**
 * Lists all persons in the contact list.
 */
public class ListContactCommand extends ListCommand {

    public static final String SECOND_COMMAND_WORD = "contact";

    public static final String MESSAGE_SUCCESS = "Listed all contacts";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredContactList(PREDICATE_SHOW_ALL_CONTACTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
