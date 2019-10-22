package seedu.planner.storage.contact;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.model.contact.Contact;
import seedu.planner.model.ReadOnlyContact;

/**
 * Represents a storage for {@link Contact}.
 */
public interface ContactStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getContactFilePath();

    /**
     * Returns Contact data as a {@link ReadOnlyContact}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyContact> readContact() throws DataConversionException, IOException;

    /**
     * @see #getContactFilePath()
     */
    Optional<ReadOnlyContact> readContact(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyContact} to the storage.
     * @param contactManager cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveContact(ReadOnlyContact contactManager) throws IOException;

    /**
     * @see #saveContact(ReadOnlyContact)
     */
    void saveContact(ReadOnlyContact planner, Path filePath) throws IOException;

}
