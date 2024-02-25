package org.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user = new User("John", "Doe");
        user1 = new User("John", "Doe");
        user2 = new User("John", "Doe");
    }

    @Test
    void testConstructorWithFirstNameAndLastName() {
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertNull(user.getUsername());
        assertNull(user.getPassword());
        assertNull(user.getIsActive());
    }

    @Test
    void testGettersAndSetters() {
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setUsername("jane.smith");
        user.setPassword("password123");
        user.setIsActive(true);

        assertEquals("Jane", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals("jane.smith", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertTrue(user.getIsActive());
    }

    @Test
    void testAllArgsConstructor() {
        User userWithAllFields = new User("Alice", "Johnson", "alice", "pass123", true);

        assertEquals("Alice", userWithAllFields.getFirstName());
        assertEquals("Johnson", userWithAllFields.getLastName());
        assertEquals("alice", userWithAllFields.getUsername());
        assertEquals("pass123", userWithAllFields.getPassword());
        assertTrue(userWithAllFields.getIsActive());
    }

    @Test
    void testNoArgsConstructor() {
        User userNoArgs = new User();

        assertNull(userNoArgs.getFirstName());
        assertNull(userNoArgs.getLastName());
        assertNull(userNoArgs.getUsername());
        assertNull(userNoArgs.getPassword());
        assertNull(userNoArgs.getIsActive());
    }

    @Test
    void testToString() {
        String expectedToString = "User(firstName=John, lastName=Doe, username=null, password=null, isActive=null)";
        assertEquals(expectedToString, user.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        assertTrue(user1.equals(user2));
        assertTrue(user2.equals(user1));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testNotEquals() {
        User user3 = new User("Alice", "Smith");
        assertFalse(user1.equals(user3));
        assertFalse(user3.equals(user1));
    }

    @Test
    void testEqualsWithNull() {
        assertFalse(user1.equals(null));
    }

    @Test
    void testHashCodeConsistency() {
        int hash1 = user1.hashCode();
        int hash2 = user1.hashCode();
        assertEquals(hash1, hash2);
    }
}
