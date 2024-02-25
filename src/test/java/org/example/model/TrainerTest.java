package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    private Trainer trainer1;
    private Trainer trainer2;

    @BeforeEach
    void setUp() {
        trainer1 = new Trainer("John", "Doe", "Java", 1);
        trainer2 = new Trainer("John", "Doe", "Java", 1);
    }

    @Test
    void testEqualsAndHashCode() {
        assertTrue(trainer1.equals(trainer2));
        assertTrue(trainer2.equals(trainer1));
        assertEquals(trainer1.hashCode(), trainer2.hashCode());
    }

    @Test
    void testNotEquals() {
        Trainer trainer3 = new Trainer("Alice", "Smith", "Python", 2);
        assertFalse(trainer1.equals(trainer3));
        assertFalse(trainer3.equals(trainer1));
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(trainer1.equals(null));
    }

    @Test
    void testHashCodeConsistency() {
        int hash1 = trainer1.hashCode();
        int hash2 = trainer1.hashCode();
        assertEquals(hash1, hash2);
    }

    @Test
    void testToString() {
        String expectedToString = "Trainer(specialization=Java, userId=1)";
        assertEquals(expectedToString, trainer1.toString());
    }
}
