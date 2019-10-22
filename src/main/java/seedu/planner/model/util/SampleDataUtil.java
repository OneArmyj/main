package seedu.planner.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.planner.model.AccommodationManager;
import seedu.planner.model.ActivityManager;
import seedu.planner.model.ContactManager;
import seedu.planner.model.Itinerary;
import seedu.planner.model.ReadOnlyAccommodation;
import seedu.planner.model.ReadOnlyActivity;
import seedu.planner.model.ReadOnlyContact;
import seedu.planner.model.ReadOnlyItinerary;
import seedu.planner.model.accommodation.Accommodation;
import seedu.planner.model.activity.Activity;
import seedu.planner.model.contact.Contact;
import seedu.planner.model.contact.Email;
import seedu.planner.model.contact.Phone;
import seedu.planner.model.day.ActivityWithTime;
import seedu.planner.model.day.Day;
import seedu.planner.model.day.time.DurationInHalfHour;
import seedu.planner.model.day.time.TimeInHalfHour;
import seedu.planner.model.field.Address;
import seedu.planner.model.field.Name;
import seedu.planner.model.tag.Tag;

/**
 * Contains utility methods for populating {@code Planner} with sample data.
 */
public class SampleDataUtil {
    public static Accommodation[] getSampleAccommodations() {
        return new Accommodation[] {
                new Accommodation(new Name("Alex Yeoh"), new Address("Blk 30 Geylang Street 29, #06-40"),
                        null, getTagSet("friends")),
                new Accommodation(new Name("Bernice Yu"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        null, getTagSet("colleagues", "friends")),
                new Accommodation(new Name("Charlotte Oliveiro"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        null, getTagSet("neighbours")),
                new Accommodation(new Name("David Li"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        null, getTagSet("family")),
                new Accommodation(new Name("Irfan Ibrahim"), new Address("Blk 47 Tampines Street 20, #17-35"),
                        null, getTagSet("classmates")),
                new Accommodation(new Name("Roy Balakrishnan"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                        null, getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAccommodation getSampleAccommodationManager() {
        AccommodationManager sampleAm = new AccommodationManager();
        for (Accommodation sampleAccommodation : getSampleAccommodations()) {
            sampleAm.addAccommodation(sampleAccommodation);
        }
        return sampleAm;
    }

    public static Activity[] getSampleActivities() {
        return new Activity[] {
                new Activity(new Name("Alex Yeoh"), new Address("Blk 30 Geylang Street 29, #06-40"),
                        null, getTagSet("friends")),
                new Activity(new Name("Bernice Yu"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        null, getTagSet("colleagues", "friends")),
                new Activity(new Name("Charlotte Oliveiro"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        null, getTagSet("neighbours")),
                new Activity(new Name("David Li"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        null, getTagSet("family")),
                new Activity(new Name("Irfan Ibrahim"), new Address("Blk 47 Tampines Street 20, #17-35"),
                        null, getTagSet("classmates")),
                new Activity(new Name("Roy Balakrishnan"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                        null, getTagSet("colleagues"))
        };
    }

    public static ReadOnlyActivity getSampleActivityManager() {
        ActivityManager sampleAm = new ActivityManager();
        for (Activity sampleActivity : getSampleActivities()) {
            sampleAm.addActivity(sampleActivity);
        }
        return sampleAm;
    }

    public static Contact[] getSampleContacts() {
        return new Contact[] {
                new Contact(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                        new Address("Blk 30 Geylang Street 29, #06-40"),
                        getTagSet("friends")),
                new Contact(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        getTagSet("colleagues", "friends")),
                new Contact(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        getTagSet("neighbours")),
                new Contact(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        getTagSet("family")),
                new Contact(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                        new Address("Blk 47 Tampines Street 20, #17-35"),
                        getTagSet("classmates")),
                new Contact(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"),
                        getTagSet("colleagues"))
        };
    }

    public static ReadOnlyContact getSampleContactManager() {
        ContactManager sampleCm = new ContactManager();
        for (Contact sampleContact : getSampleContacts()) {
            sampleCm.addContact(sampleContact);
        }
        return sampleCm;
    }

    // Need to add more samples
    public static Day[] getSampleDays() {
        ArrayList<ActivityWithTime> sampleActivities = new ArrayList<>();
        Activity a = new Activity(new Name("Go Ocean Park"), new Address("Tokyo"), null, getTagSet("epic"));
        sampleActivities.add(new ActivityWithTime(a, new TimeInHalfHour(9, 30), new DurationInHalfHour(3)) );

        return new Day[] {
                new Day(sampleActivities)
        };
    }

    public static ReadOnlyItinerary getSampleItinerary() {
        Itinerary sampleItinerary = new Itinerary();
        sampleItinerary.setDays(Arrays.asList(getSampleDays()));
        return sampleItinerary;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
