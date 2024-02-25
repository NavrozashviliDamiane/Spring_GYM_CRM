package org.example.service;

import org.example.dao.TraineeDAO;
import org.example.model.Trainee;
import org.example.util.PasswordGenerator;
import org.example.util.UsernameGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TraineeServiceTest {

    @Mock
    private TraineeDAO traineeDAO;

    @Mock
    private PasswordGenerator passwordGenerator;

    @Mock
    private UsernameGenerator usernameGenerator;

    @InjectMocks
    private TraineeService traineeService;

    private Trainee trainee;

    @BeforeEach
    void setUp() {
        trainee = new Trainee("John", "Doe", null, null, 1);
    }

    @Test
    public void testCreateTrainee() {
        Trainee trainee = new Trainee("John", "Doe", LocalDate.now(), "Address", 1);

        String generatedPassword = "generatedPassword";
        when(passwordGenerator.generatePassword()).thenReturn(generatedPassword);

        traineeService.createTrainee(trainee);

        verify(traineeDAO).save(trainee);

        String expectedUsername = usernameGenerator.generateUsername(trainee.getFirstName(), trainee.getLastName(), trainee);
        assertEquals(expectedUsername, trainee.getUsername());

        assertNotNull(trainee.getPassword());
        assertEquals(generatedPassword, trainee.getPassword());
    }

    @Test
    void testUpdateTrainee() {
        traineeService.updateTrainee(trainee);

        verify(traineeDAO, times(1)).update(trainee);
    }

    @Test
    void testDeleteTrainee_Exists() {
        when(traineeDAO.findById(trainee.getUserId())).thenReturn(trainee);

        traineeService.deleteTrainee(trainee.getUserId());

        verify(traineeDAO, times(1)).delete(trainee.getUserId());
    }

    @Test
    void testDeleteTrainee_NotExists() {
        when(traineeDAO.findById(trainee.getUserId())).thenReturn(null);

        traineeService.deleteTrainee(trainee.getUserId());

        verify(traineeDAO, never()).delete(trainee.getUserId());
    }

    @Test
    void testFindTraineeById() {
        when(traineeDAO.findById(trainee.getUserId())).thenReturn(trainee);

        Trainee foundTrainee = traineeService.findTraineeById(trainee.getUserId());

        assertEquals(trainee, foundTrainee);
    }
}
