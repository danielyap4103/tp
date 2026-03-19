package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final TeleHandle teleHandle;
    private final StudentId studentId;

    // Data fields
    private final TutorialGroup tutorialGroup;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, TeleHandle teleHandle, StudentId studentId,
                  TutorialGroup tutorialGroup) {
        requireAllNonNull(name, phone, email, teleHandle, studentId, tutorialGroup);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.teleHandle = teleHandle;
        this.studentId = studentId;
        this.tutorialGroup = tutorialGroup;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public TeleHandle getTeleHandle() {
        return teleHandle;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public TutorialGroup getTutorialGroup() {
        return tutorialGroup;
    }

    /**
     * Returns true if both persons have the same student ID.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getStudentId().equals(getStudentId());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && teleHandle.equals(otherPerson.teleHandle)
                && studentId.equals(otherPerson.studentId)
                && tutorialGroup.equals(otherPerson.tutorialGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, teleHandle, studentId, tutorialGroup);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("studentId", studentId)
                .add("email", email)
                .add("phone", phone)
                .add("teleHandle", teleHandle)
                .add("tutorialGroup", tutorialGroup)
                .toString();
    }

}
