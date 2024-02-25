package org.example.util;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.storage.GymStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsernameGeneratorTest {

    @Mock
    private GymStorage gymStorage;

    @Mock
    private Logger logger;

    @InjectMocks
    private UsernameGenerator usernameGenerator;

    @Test
    public void generateUsername_trainer_usernameNotExists() {
        String firstName = "John";
        String lastName = "Doe";
        Trainer trainer = new Trainer();

        when(gymStorage.trainerUsernameExists(firstName + "." + lastName)).thenReturn(false);

        String username = usernameGenerator.generateUsername(firstName, lastName, trainer);

        assertEquals(firstName + "." + lastName, username);
    }

    @Test
    public void generateUsername_trainer_usernameExists() {
        String firstName = "John";
        String lastName = "Doe";
        Trainer trainer = new Trainer();

        when(gymStorage.trainerUsernameExists(firstName + "." + lastName)).thenReturn(true);
        when(gymStorage.trainerUsernameExists(firstName + "." + lastName + "1")).thenReturn(false);

        String username = usernameGenerator.generateUsername(firstName, lastName, trainer);

        assertEquals(firstName + "." + lastName + "1", username);
    }

    @Test
    public void generateUsername_trainee_usernameNotExists() {
        String firstName = "Jane";
        String lastName = "Smith";
        Trainee trainee = new Trainee();

        when(gymStorage.traineeUsernameExists(firstName + "." + lastName)).thenReturn(false);

        String username = usernameGenerator.generateUsername(firstName, lastName, trainee);

        assertEquals(firstName + "." + lastName, username);
    }

    @Test
    public void generateUsername_trainee_usernameExists() {
        String firstName = "Jane";
        String lastName = "Smith";
        Trainee trainee = new Trainee();

        when(gymStorage.traineeUsernameExists(firstName + "." + lastName)).thenReturn(true);
        when(gymStorage.traineeUsernameExists(firstName + "." + lastName + "1")).thenReturn(false);

        String username = usernameGenerator.generateUsername(firstName, lastName, trainee);

        assertEquals(firstName + "." + lastName + "1", username);
    }
}
