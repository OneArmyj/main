package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ContactManager;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAccommodation;
import seedu.address.model.ReadOnlyActivity;
import seedu.address.model.ReadOnlyContact;
import seedu.address.model.ReadOnlyItinerary;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.contact.Contact;
import seedu.address.model.contact.Phone;
import seedu.address.model.day.Day;
import seedu.address.model.field.Name;
import seedu.address.model.itineraryitem.accommodation.Accommodation;
import seedu.address.model.itineraryitem.activity.Activity;
import seedu.address.testutil.ContactBuilder;

public class AddContactCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddContactCommand((Contact) null));
    }

    @Test
    public void execute_contactAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingContactAdded modelStub = new ModelStubAcceptingContactAdded();
        Contact validContact = new ContactBuilder().build();

        CommandResult commandResult = new AddContactCommand(validContact).execute(modelStub);

        assertEquals(String.format(AddContactCommand.MESSAGE_SUCCESS, validContact), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validContact), modelStub.contactsAdded);
    }

    @Test
    public void execute_duplicateContact_throwsCommandException() {
        Contact validContact = new ContactBuilder().build();
        AddCommand addContactCommand = new AddContactCommand(validContact);
        ModelStub modelStub = new ModelStubWithContact(validContact);

        assertThrows(CommandException.class,
                AddContactCommand.MESSAGE_DUPLICATE_CONTACT, () -> addContactCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Contact alice = new ContactBuilder().withName("Alice").build();
        Contact bob = new ContactBuilder().withName("Bob").build();
        AddContactCommand addAliceCommand = new AddContactCommand(alice);
        AddContactCommand addBobCommand = new AddContactCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddContactCommand addAliceCommandCopy = new AddContactCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different contacts -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        // ACCOMMODATION METHODS
        @Override
        public Path getAccommodationFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAccommodationFilePath(Path accommodationFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addAccommodation(Accommodation accommodation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addAccommodationAtIndex(Index index, Accommodation accommodation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasAccommodation(Accommodation accommodation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteAccommodation(Accommodation target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAccommodation(Accommodation target, Accommodation editedAccommodation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAccommodations(ReadOnlyAccommodation accommodations) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAccommodation getAccommodations() {
            throw new AssertionError("This method should not be called.");
        }

        // ACTIVITY METHODS
        @Override
        public Path getActivityFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setActivityFilePath(Path activityFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setActivities(ReadOnlyActivity activities) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyActivity getActivities() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addActivity(Activity activity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addActivityAtIndex(Index index, Activity activity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasActivity(Activity activity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteActivity(Activity target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setActivity(Activity target, Activity editedActivity) {
            throw new AssertionError("This method should not be called.");
        }

        // CONTACT METHODS
        @Override
        public Path getContactFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContactFilePath(Path contactFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContacts(ReadOnlyContact contacts) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyContact getContacts() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContactAtIndex(Index index, Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPhone(Phone phone) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteContact(Contact target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContact(Contact target, Contact editedContact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<Contact> getContactByPhone(Phone phone) {
            throw new AssertionError("This method should not be called.");
        }

        // DAY METHODS
        @Override
        public Path getItineraryFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setItineraryFilePath(Path itineraryFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setItinerary(ReadOnlyItinerary itinerary) {
            throw new AssertionError("This method should not be called.");
        }

        public ReadOnlyItinerary getItinerary() {
            throw new AssertionError("This method should not be called.");
        }

        public Name getName() {
            throw new AssertionError("This method should not be called.");
        }

        public void setItineraryName(Name name) {
            throw new AssertionError("This method should not be called.");
        }

        public LocalDate getStartDate() {
            throw new AssertionError("This method should not be called.");
        }

        public void setItineraryStartDate(LocalDate date) {
            throw new AssertionError("This method should not be called.");
        }

        public void addDays(int n) {
            throw new AssertionError("This method should not be called.");
        }

        public void deleteDay(Day target) {
            throw new AssertionError("This method should not be called.");
        }

        public void setDays(ReadOnlyItinerary itinerary) {
            throw new AssertionError("This method should not be called.");
        }

        public void setDays(List<Day> days) {
            throw new AssertionError("This method should not be called.");
        }

        public boolean hasDay(Day day) {
            throw new AssertionError("This method should not be called");
        }

        public ObservableList<Day> getFilteredItinerary() {
            throw new AssertionError("This method should not be called.");
        }

        public void updateFilteredItinerary(Predicate<Day> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        // FILTERED LIST METHODS
        @Override
        public ObservableList<Accommodation> getFilteredAccommodationList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredAccommodationList(Predicate<Accommodation> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Activity> getFilteredActivityList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredActivityList(Predicate<Activity> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Contact> getFilteredContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredContactList(Predicate<Contact> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single contacts.
     */
    private class ModelStubWithContact extends ModelStub {
        private final Contact contact;

        ModelStubWithContact(Contact contact) {
            requireNonNull(contact);
            this.contact = contact;
        }

        @Override
        public boolean hasContact(Contact contact) {
            requireNonNull(contact);
            return this.contact.isSameContact(contact);
        }
    }

    /**
     * A Model stub that always accept the contacts being added.
     */
    private class ModelStubAcceptingContactAdded extends ModelStub {
        final ArrayList<Contact> contactsAdded = new ArrayList<>();

        @Override
        public boolean hasContact(Contact contact) {
            requireNonNull(contact);
            return contactsAdded.stream().anyMatch(contact::isSameContact);
        }

        @Override
        public void addContact(Contact contact) {
            requireNonNull(contact);
            contactsAdded.add(contact);
        }

        @Override
        public ReadOnlyContact getContacts() {
            return new ContactManager();
        }
    }

}
