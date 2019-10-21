package seedu.planner.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_START_TIME;
import static seedu.planner.model.Model.PREDICATE_SHOW_ALL_DAYS;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.day.ActivityWithTime;
import seedu.planner.model.day.Day;
import seedu.planner.model.day.time.TimeInHalfHour;

/**
 * Unschedules an activity from the day by time.
 */
public class UnscheduleTimeCommand extends UnscheduleCommand {

    public static final String SECOND_COMMAND_WORD = "time";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + SECOND_COMMAND_WORD + " "
            + ": Unschedules an activity by a time occupied by the activity on a certain day. "
            + "Parameters: "
            + PREFIX_START_TIME + "TIME "
            + PREFIX_DAY + "DAY";

    public static final String MESSAGE_UNSCHEDULE_TIME_SUCCESS = "Activity unscheduled: %1$s";
    public static final String MESSAGE_DUPLICATE_DAY = "This day already exists in the planner.";

    private final Index dayIndex;
    private final TimeInHalfHour startTime;

    /**
     * @param dayIndex of the contacts in the filtered contacts list to edit
     * @param startTime details to edit the contacts with
     */
    public UnscheduleTimeCommand(TimeInHalfHour startTime, Index dayIndex) {
        requireNonNull(dayIndex);
        requireNonNull(startTime);
        this.dayIndex = dayIndex;
        this.startTime = startTime;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Day> lastShownDays = model.getFilteredItinerary();

        if (dayIndex.getZeroBased() >= lastShownDays.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_DAY_DISPLAYED_INDEX);
        }

        Day dayToEdit = lastShownDays.get(dayIndex.getZeroBased());
        Day editedDay = createUnscheduledActivityDay(dayToEdit, this.startTime);
        List<Day> editedDays = new ArrayList<>(lastShownDays);
        editedDays.set(dayIndex.getZeroBased(), editedDay);

        if (!dayToEdit.isSameDay(editedDay) && model.hasDay(editedDay)) {
            throw new CommandException(MESSAGE_DUPLICATE_DAY);
        }

        model.setDays(editedDays);
        model.updateFilteredItinerary(PREDICATE_SHOW_ALL_DAYS);
        return new CommandResult(String.format(MESSAGE_UNSCHEDULE_TIME_SUCCESS, editedDay));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UnscheduleTimeCommand // instanceof handles nulls
                && this.dayIndex.equals(((UnscheduleTimeCommand) other).dayIndex)
                && this.startTime.equals(((UnscheduleTimeCommand) other).startTime));
    }

    /**
     * Creates a new day without the activity that is unscheduled.
     * @param dayToEdit of the contacts in the filtered contacts list to edit
     * @param startTime of the contacts in the filtered contacts list to edit
     */
    private Day createUnscheduledActivityDay(Day dayToEdit, TimeInHalfHour startTime) {
        List<ActivityWithTime> activitiesWithTime = dayToEdit.getActivitiesWithTime();
        List<ActivityWithTime> editedActivitiesWithTime = new ArrayList<>();
        for (ActivityWithTime a : activitiesWithTime) {
            if (!a.getTime().equals(startTime)) {
                editedActivitiesWithTime.add(a);
            }
        }
        return new Day(editedActivitiesWithTime);
    }
}
