package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TutorialGroupTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TutorialGroup(null));
    }

    @Test
    public void constructor_invalidTutorialGroup_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup(""));
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup("friend"));
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup("T1"));
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup("T123"));
    }

    @Test
    public void isValidTutorialGroup() {
        // null tutorial group
        assertThrows(NullPointerException.class, () -> TutorialGroup.isValidTutorialGroup(null));

        // invalid tutorial groups
        assertFalse(TutorialGroup.isValidTutorialGroup(""));
        assertFalse(TutorialGroup.isValidTutorialGroup("friend"));
        assertFalse(TutorialGroup.isValidTutorialGroup("T1"));
        assertFalse(TutorialGroup.isValidTutorialGroup("T123"));
        assertFalse(TutorialGroup.isValidTutorialGroup("t01"));
        assertFalse(TutorialGroup.isValidTutorialGroup("A01"));
        assertFalse(TutorialGroup.isValidTutorialGroup("TAB"));
        assertFalse(TutorialGroup.isValidTutorialGroup("#friend"));

        // valid tutorial groups (T + exactly 2 digits)
        assertTrue(TutorialGroup.isValidTutorialGroup("T01"));
        assertTrue(TutorialGroup.isValidTutorialGroup("T12"));
        assertTrue(TutorialGroup.isValidTutorialGroup("T00"));
        assertTrue(TutorialGroup.isValidTutorialGroup("T99"));
    }

    @Test
    public void equals() {
        TutorialGroup tutorialGroup = new TutorialGroup("T01");

        // same values -> returns true
        assertTrue(tutorialGroup.equals(new TutorialGroup("T01")));

        // same object -> returns true
        assertTrue(tutorialGroup.equals(tutorialGroup));

        // null -> returns false
        assertFalse(tutorialGroup.equals(null));

        // different types -> returns false
        assertFalse(tutorialGroup.equals(5.0f));

        // different values -> returns false
        assertFalse(tutorialGroup.equals(new TutorialGroup("T02")));
    }

    @Test
    public void hashCodeTest() {
        TutorialGroup tutorialGroup = new TutorialGroup("T01");
        assertEquals(tutorialGroup.hashCode(), new TutorialGroup("T01").hashCode());
    }
}
