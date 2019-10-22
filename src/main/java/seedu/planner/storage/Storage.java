package seedu.planner.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.model.*;
import seedu.planner.storage.accommodation.AccommodationStorage;
import seedu.planner.storage.activity.ActivityStorage;
import seedu.planner.storage.contact.ContactStorage;
import seedu.planner.storage.day.ItineraryStorage;

/**
 * API of the Storage component
 */
public interface Storage extends AccommodationStorage, ActivityStorage, ContactStorage, ItineraryStorage,
        UserPrefsStorage {

    // ================ UserPrefs methods ==============================

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    // ================ AccommodationStorage methods ==============================

    @Override
    Path getAccommodationFilePath();

    @Override
    Optional<ReadOnlyAccommodation> readAccommodation() throws DataConversionException, IOException;

    @Override
    void saveAccommodation(ReadOnlyAccommodation accommodation) throws IOException;

    // ================ ActivityStorage methods ==============================

    @Override
    Path getActivityFilePath();

    @Override
    Optional<ReadOnlyActivity> readActivity() throws DataConversionException, IOException;

    @Override
    void saveActivity(ReadOnlyActivity activity) throws IOException;

    // ================ ContactStorage methods ==============================

    @Override
    Path getContactFilePath();

    @Override
    Optional<ReadOnlyContact> readContact() throws DataConversionException, IOException;

    @Override
    void saveContact(ReadOnlyContact contact) throws IOException;

    // ================ ItineraryStorage methods ==============================

    @Override
    Path getItineraryFilePath();

    @Override
    Optional<ReadOnlyItinerary> readItinerary() throws DataConversionException, IOException;

    @Override
    void saveItinerary(ReadOnlyItinerary itinerary) throws IOException;
}
