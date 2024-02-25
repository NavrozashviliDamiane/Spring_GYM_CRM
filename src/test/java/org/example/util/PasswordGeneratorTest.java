package org.example.util;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PasswordGeneratorTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private PasswordGenerator passwordGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generatePassword_Length() {
        String generatedPassword = passwordGenerator.generatePassword();

        assertEquals(10, generatedPassword.length());
        verify(logger).info("Generated password: {}", generatedPassword);
    }

    @Test
    void generatePassword_ContainsUppercase() {
        String generatedPassword = passwordGenerator.generatePassword();

        assertTrue(generatedPassword.matches(".*[A-Z].*"));
        verify(logger).info("Generated password: {}", generatedPassword);
    }

    @Test
    void generatePassword_ContainsLowercase() {
        String generatedPassword = passwordGenerator.generatePassword();

        assertTrue(generatedPassword.matches(".*[a-z].*"));
        verify(logger).info("Generated password: {}", generatedPassword);
    }


    @Test
    void generatePassword_NotEmpty() {
        String generatedPassword = passwordGenerator.generatePassword();

        assertNotNull(generatedPassword);
        assertFalse(generatedPassword.isEmpty());
        verify(logger).info("Generated password: {}", generatedPassword);
    }
}
