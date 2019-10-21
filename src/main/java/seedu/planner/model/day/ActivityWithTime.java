package seedu.planner.model.day;

import seedu.planner.model.activity.Activity;
import seedu.planner.model.day.time.DurationInHalfHour;
import seedu.planner.model.day.time.TimeInHalfHour;

/**
 * Wraps the Activity in an object with time and duration fields.
 */
public class ActivityWithTime {
    private final Activity activity;
    private final TimeInHalfHour time;
    private final DurationInHalfHour duration;

    public ActivityWithTime(Activity activity, TimeInHalfHour time, DurationInHalfHour duration) {
        this.activity = activity;
        this.time = time;
        this.duration = duration;
    }

    public Activity getActivity() {
        return activity;
    }

    public TimeInHalfHour getTime() {
        return time;
    }

    public DurationInHalfHour getDuration() {
        return duration;
    }
}
