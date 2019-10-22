package seedu.planner.storage.day;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.day.time.TimeInHalfHour;

/**
 * Jackson-friendly version of {@link TimeInHalfHour}.
 */
public class JsonAdaptedTimeInHalfHour {

    private final String time;

    /**
     * Constructs a {@code JsonAdaptedTimeInHalfHour} with the given timeInHalfHour's details.
     */
    @JsonCreator
    public JsonAdaptedTimeInHalfHour(@JsonProperty("timeInHalfHour") String time) {
        this.time = time;
    }

    /**
     * Converts a given {@code TimeInHalfHour} into this class for Jackson use.
     */
    public JsonAdaptedTimeInHalfHour(TimeInHalfHour source) {
        time = String.format("%d %d", source.getHour(), source.getMinutes());
    }

    /**
     * Converts this Jackson-friendly adapted timeInHalfHour object into the day's {@code TimeInHalfHour} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted timeInHalfHours.
     */
    public TimeInHalfHour toModelType() throws IllegalValueException {
        if (!TimeInHalfHour.isValidTime(time)) {
            throw new IllegalValueException(String.format(TimeInHalfHour.MESSAGE_CONSTRAINTS));
        }
        String[] arrayOfString = time.split("\\s");
        int hours = Integer.parseInt(arrayOfString[0]);
        int minutes = Integer.parseInt(arrayOfString[1]);
        return new TimeInHalfHour(hours, minutes);
    }

}
