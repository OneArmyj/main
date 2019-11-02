package seedu.planner.logic.events.edit;

import java.util.List;

import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.commands.EditAccommodationCommand;
import seedu.planner.logic.commands.EditAccommodationCommand.EditAccommodationDescriptor;
import seedu.planner.logic.commands.UndoableCommand;
import seedu.planner.logic.events.Event;
import seedu.planner.model.Model;
import seedu.planner.model.accommodation.Accommodation;

/**
 * An event representing a 'edit accommodation' command.
 */
public class EditAccommodationEvent implements Event {
    private final Index index;
    private final EditAccommodationDescriptor editInfo;
    private final EditAccommodationDescriptor reverseEditInfo;

    public EditAccommodationEvent(Index index, EditAccommodationDescriptor editInfo, Model model) {
        this.index = index;
        this.editInfo = editInfo;
        this.reverseEditInfo = generateReverseEditInfo(model);
    }

    public UndoableCommand undo() {
        return new EditAccommodationCommand(index, reverseEditInfo);
    }

    public UndoableCommand redo() {
        return new EditAccommodationCommand(index, editInfo);
    }

    /**
     * A method to construct an EditAccommodationDescriptor based on the current Accommodation to edit in the model.
     * @param model Current model in the application.
     * @return the EditAccommodationDescriptor containing information of the original Accommodation to be edited.
     */
    private EditAccommodationDescriptor generateReverseEditInfo(Model model) {
        EditAccommodationDescriptor result = new EditAccommodationDescriptor();

        List<Accommodation> lastShownList = model.getFilteredAccommodationList();
        assert(index.getZeroBased() < lastShownList.size());

        Accommodation originalAccommodation = lastShownList.get(index.getZeroBased());

        result.setName(originalAccommodation.getName());
        result.setAddress(originalAccommodation.getAddress());
        if (originalAccommodation.getContact().isPresent()) {
            result.setPhone(originalAccommodation.getContact().get().getPhone());
        } else {
            result.setPhone(null);
        }
        result.setTags(originalAccommodation.getTags());

        return result;
    }
}