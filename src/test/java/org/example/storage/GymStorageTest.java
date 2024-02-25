package org.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.test.util.ReflectionTestUtils;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GymStorageTest {

    @Mock
    private Logger logger;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private Resource dataFile;

    @InjectMocks
    private GymStorage gymStorage;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(gymStorage, "trainers", new HashMap<>());
        ReflectionTestUtils.setField(gymStorage, "trainees", new HashMap<>());
    }

    @Test
    void testTrainerUsernameExists() {
        Trainer trainer = new Trainer("John", "Doe", "Specialization", 1);
        trainer.setUsername("johndoe");
        gymStorage.getTrainers().put(1, trainer);

        assertTrue(gymStorage.trainerUsernameExists("johndoe"));
        assertFalse(gymStorage.trainerUsernameExists("janedoe"));
    }

    @Test
    void testTraineeUsernameExists() {
        Trainee trainee = new Trainee("Jane", "Doe", null, null, 1);
        trainee.setUsername("janedoe");
        gymStorage.getTrainees().put(1, trainee);

        assertTrue(gymStorage.traineeUsernameExists("janedoe"));
        assertFalse(gymStorage.traineeUsernameExists("johndoe"));
    }

    @Test
    void testInitialize_ErrorHandling() throws IOException {
        when(dataFile.getFile()).thenThrow(new IOException("File not found"));

        gymStorage.initialize();

        verify(logger).error("Error loading data from file: {}", "File not found");
    }

}
