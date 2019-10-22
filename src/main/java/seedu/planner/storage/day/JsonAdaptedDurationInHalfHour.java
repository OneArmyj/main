package seedu.planner.storage.day;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.day.time.DurationInHalfHour;

/**
 * Jackson-friendly version of {@link DurationInHalfHour}.
 */
public class JsonAdaptedDurationInHalfHour {

    private final String numberOfHalfHour;

    /**
     * Constructs a {@code JsonAdaptedDurationInHalfHour} with the given numberOfHalfHour's details.
     */
    @JsonCreator
    public JsonAdaptedDurationInHalfHour(@JsonProperty("numberOfHalfHour") String numberOfHalfHour) {
        this.numberOfHalfHour = numberOfHalfHour;
    }

    /**
     * Converts a given {@code Day} into this class for Jackson use.
     */
    public JsonAdaptedDurationInHalfHour(DurationInHalfHour source) {
        numberOfHalfHour = String.format("%d", source.getNumberOfHalfHour());
    }

    /**
     * Converts this Jackson-friendly adapted durationInHalfHours object into the day's {@code DurationWithHalfHour}
     * object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted durationInHalfHours.
     */
    public DurationInHalfHour toModelType() throws IllegalValueException {
        if (!DurationInHalfHour.isValidDuration(numberOfHalfHour)) {
            throw new IllegalValueException(DurationInHalfHour.MESSAGE_CONSTRAINTS);
        }

        return new DurationInHalfHour(Integer.parseInt(numberOfHalfHour));
    }

}
