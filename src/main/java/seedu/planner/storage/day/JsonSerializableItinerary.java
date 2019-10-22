package seedu.planner.storage.day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.Itinerary;
import seedu.planner.model.ReadOnlyItinerary;
import seedu.planner.model.contact.Contact;
import seedu.planner.model.day.Day;

/**
 * An Immutable Itinerary that is serializable to JSON format.
 */
@JsonRootName(value = "itinerary")
class JsonSerializableItinerary {

    public static final String MESSAGE_DUPLICATE_DAY = "Days list contains duplicate days(s).";

    private final List<JsonAdaptedDay> days = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableItinerary} with the given days.
     */
    @JsonCreator
    public JsonSerializableItinerary(@JsonProperty("days") List<JsonAdaptedDay> days) {
        this.days.addAll(days);
    }

    /**
     * Converts a given {@code ReadOnlyItinerary} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableItinerary}.
     */
    public JsonSerializableItinerary(ReadOnlyItinerary source) {
        days.addAll(source.getItinerary().stream().map(JsonAdaptedDay::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code Itinerary} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Itinerary toModelType() throws IllegalValueException {
        Itinerary itinerary = new Itinerary();
        for (JsonAdaptedDay jsonAdaptedDay : days) {
            Day day = jsonAdaptedDay.toModelType();
            if (itinerary.hasDay(day)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_DAY);
            }
            itinerary.addDay(day);
        }
        return itinerary;
    }

}
