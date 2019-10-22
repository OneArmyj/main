package seedu.planner.storage.day;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.activity.Activity;
import seedu.planner.model.day.ActivityWithTime;
import seedu.planner.model.day.Day;
import seedu.planner.model.day.time.DurationInHalfHour;
import seedu.planner.model.day.time.TimeInHalfHour;
import seedu.planner.storage.activity.JsonAdaptedActivity;

/**
 * Jackson-friendly version of {@link Day}.
 */
public class JsonAdaptedActivityWithTime {

    private final JsonAdaptedActivity activity;
    private final JsonAdaptedTimeInHalfHour timeInHalfHour;
    private final JsonAdaptedDurationInHalfHour durationInHalfHour;

    /**
     * Constructs a {@code JsonAdaptedActivityWithTime} with the given days details.
     */
    @JsonCreator
    public JsonAdaptedActivityWithTime(@JsonProperty("activity") JsonAdaptedActivity activity,
                          @JsonProperty("timeInHalfHour") JsonAdaptedTimeInHalfHour timeInHalfHour,
                          @JsonProperty("durationInHalfHour") JsonAdaptedDurationInHalfHour durationInHalfHour) {
        this.activity = activity;
        this.timeInHalfHour = timeInHalfHour;
        this.durationInHalfHour = durationInHalfHour;
    }

    /**
     * Converts a given {@code Day} into this class for Jackson use.
     */
    public JsonAdaptedActivityWithTime(ActivityWithTime source) {
        activity = new JsonAdaptedActivity(source.getActivity());
        timeInHalfHour = new JsonAdaptedTimeInHalfHour(source.getTime());
        durationInHalfHour = new JsonAdaptedDurationInHalfHour(source.getDuration());
    }

    /**
     * Converts various Jackson-friendly adapted class objects into the day's {@code ActivityWithTime} object.
     */
    public ActivityWithTime toModelType() throws IllegalValueException {
        final Activity modelActivity = activity.toModelType();
        final TimeInHalfHour modelTimeInHalfHour = timeInHalfHour.toModelType();
        final DurationInHalfHour modelDurationInHalfHour = durationInHalfHour.toModelType();
        return new ActivityWithTime(modelActivity, modelTimeInHalfHour, modelDurationInHalfHour);
    }

}
