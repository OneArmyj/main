package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.Model;
import seedu.address.model.itineraryitem.accommodation.Accommodation;

/**
 * Removes an accommodation from the accommodation list.
 */
public class DeleteAccommodationCommand extends DeleteCommand {
    public static final String SECOND_COMMAND_WORD = "accommodation";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the accommodation identified by the index number used in the displayed accommodation list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " " + SECOND_COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_ACCOMMODATION_SUCCESS = "Deleted Accommodation: %1$s";

    private final Index targetIndex;
    private final Accommodation toDelete;

    public DeleteAccommodationCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
        toDelete = null;
    }

    public DeleteAccommodationCommand(Accommodation accommodation) {
        toDelete = accommodation;
        targetIndex = null;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Accommodation> lastShownList = model.getFilteredAccommodationList();
        Accommodation accommodationToDelete;

        if (toDelete != null) {
            accommodationToDelete = toDelete;
        } else if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACCOMMODATION_DISPLAYED_INDEX);
        } else {
            accommodationToDelete = lastShownList.get(targetIndex.getZeroBased());
        }

        model.deleteAccommodation(accommodationToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_ACCOMMODATION_SUCCESS, accommodationToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteAccommodationCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteAccommodationCommand) other).targetIndex)); // state check
    }
}
