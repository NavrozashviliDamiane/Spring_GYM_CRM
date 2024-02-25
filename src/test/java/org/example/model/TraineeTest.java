package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TraineeTest {

    private Trainee trainee1;
    private Trainee trainee2;

    @BeforeEach
    void setUp() {
        trainee1 = new Trainee("John", "Doe", LocalDate.of(2000, 5, 15), "123 Main St", 1);
        trainee2 = new Trainee("John", "Doe", LocalDate.of(2000, 5, 15), "123 Main St", 1);
    }

    @Test
    void testEqualsAndHashCode() {
        assertTrue(trainee1.equals(trainee2));
        assertTrue(trainee2.equals(trainee1));
        assertEquals(trainee1.hashCode(), trainee2.hashCode());
    }

    @Test
    void testNotEquals() {
        Trainee trainee3 = new Trainee("Alice", "Smith", LocalDate.of(1995, 8, 20), "456 Elm St", 2);
        assertFalse(trainee1.equals(trainee3));
        assertFalse(trainee3.equals(trainee1));
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(trainee1.equals(null));
    }

    @Test
    void testHashCodeConsistency() {
        int hash1 = trainee1.hashCode();
        int hash2 = trainee1.hashCode();
        assertEquals(hash1, hash2);
    }

    @Test
    void testToString() {
        String expectedToString = "Trainee(dateOfBirth=2000-05-15, address=123 Main St, userId=1)";
        assertEquals(expectedToString, trainee1.toString());
    }

}
