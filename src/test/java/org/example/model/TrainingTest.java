package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingTest {

    private Training training1;
    private Training training2;
    private Training training3;

    @BeforeEach
    void setUp() {
        training1 = new Training(1, 2, "Java Basics", TrainingType.YOGA, LocalDate.of(2024, 2, 26), 60);
        training2 = new Training(1, 2, "Java Basics", TrainingType.YOGA, LocalDate.of(2024, 2, 26), 60);
        training3 = new Training(2, 3, "Python Basics", TrainingType.YOGA, LocalDate.of(2024, 3, 1), 45);
    }

    @Test
    void testEqualsAndHashCode() {
        assertTrue(training1.equals(training2));
        assertTrue(training2.equals(training1));
        assertEquals(training1.hashCode(), training2.hashCode());
    }

    @Test
    void testNotEquals() {
        assertFalse(training1.equals(training3));
        assertFalse(training3.equals(training1));
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(training1.equals(null));
    }

    @Test
    void testEqualsWithDifferentClass() {
        assertFalse(training1.equals("Not a Training object"));
    }

    @Test
    void testHashCodeConsistency() {
        int hash1 = training1.hashCode();
        int hash2 = training1.hashCode();
        assertEquals(hash1, hash2);
    }

    @Test
    void testHashCodeInequality() {
        assertNotEquals(training1.hashCode(), training3.hashCode());
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1, training1.getTraineeId());
        assertEquals(2, training1.getTrainerId());
        assertEquals("Java Basics", training1.getTrainingName());
        assertEquals(TrainingType.YOGA, training1.getTrainingType());
        assertEquals(LocalDate.of(2024, 2, 26), training1.getTrainingDate());
        assertEquals(60, training1.getTrainingDuration());

        training1.setTraineeId(3);
        assertEquals(3, training1.getTraineeId());

        training1.setTrainerId(4);
        assertEquals(4, training1.getTrainerId());

        training1.setTrainingName("New Name");
        assertEquals("New Name", training1.getTrainingName());

        training1.setTrainingType(TrainingType.YOGA);
        assertEquals(TrainingType.YOGA, training1.getTrainingType());

        training1.setTrainingDate(LocalDate.of(2024, 3, 1));
        assertEquals(LocalDate.of(2024, 3, 1), training1.getTrainingDate());

        training1.setTrainingDuration(90);
        assertEquals(90, training1.getTrainingDuration());
    }

    @Test
    void testEquals() {
        assertTrue(training1.equals(training1));

        assertTrue(training1.equals(training2));
        assertTrue(training2.equals(training1));

        assertFalse(training1.equals(training3));
        assertFalse(training3.equals(training1));

        assertFalse(training1.equals(null));

        assertFalse(training1.equals("Not a Training object"));
    }
}
