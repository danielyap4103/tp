package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.StudentId;
import seedu.address.model.person.TeleHandle;
import seedu.address.model.person.TutorialGroup;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@u.nus.edu"),
                new TeleHandle("@alexyeoh"), new StudentId("A0123456A"), new TutorialGroup("T01")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@u.nus.edu"),
                new TeleHandle("@berniceyu"), new StudentId("A0123456B"), new TutorialGroup("T02")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@u.nus.edu"),
                new TeleHandle("@charlotteo"), new StudentId("A0123456C"), new TutorialGroup("T03")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@u.nus.edu"),
                new TeleHandle("@davidli"), new StudentId("A0123456D"), new TutorialGroup("T04")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@u.nus.edu"),
                new TeleHandle("@irfanib"), new StudentId("A0123456E"), new TutorialGroup("T05")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@u.nus.edu"),
                new TeleHandle("@roybala"), new StudentId("A0123456F"), new TutorialGroup("T02"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

}
