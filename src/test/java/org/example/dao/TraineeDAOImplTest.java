package org.example.dao;

import org.example.model.Trainee;
import org.example.storage.GymStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraineeDAOImplTest {

    @Mock
    private GymStorage gymStorage;

    @InjectMocks
    private TraineeDAOImpl traineeDAO;

    @Test
    public void testSave() {
        int traineeId = 1;
        Trainee traineeToSave = new Trainee("John", "Doe", null, null, traineeId);

        Map<Integer, Trainee> trainees = new HashMap<>();
        when(gymStorage.getTrainees()).thenReturn(trainees);

        traineeDAO.save(traineeToSave);

        assertEquals(1, trainees.size()); // Ensure trainee is saved
        assertEquals(traineeToSave, trainees.get(traineeId)); // Ensure correct trainee is saved
        verify(gymStorage).getTrainees(); // Verify method call
    }

    @Test
    public void testFindById_ExistingTrainee() {
        Trainee expectedTrainee = new Trainee("John", "Doe", null, null, 1);
        Map<Integer, Trainee> traineeMap = new HashMap<>();
        traineeMap.put(1, expectedTrainee);
        when(gymStorage.getTrainees()).thenReturn(traineeMap);

        Trainee actualTrainee = traineeDAO.findById(1);

        assertEquals(expectedTrainee, actualTrainee);
    }

    @Test
    public void testFindById_NonExistingTrainee() {
        Map<Integer, Trainee> traineeMap = new HashMap<>();
        when(gymStorage.getTrainees()).thenReturn(traineeMap);

        Trainee actualTrainee = traineeDAO.findById(2);

        assertNull(actualTrainee);
    }

    @Test
    public void testDelete_TraineeExists() {
        int traineeId = 1;
        Map<Integer, Trainee> trainees = new HashMap<>();
        Trainee traineeToDelete = new Trainee("John", "Doe", null, null, traineeId);
        trainees.put(traineeId, traineeToDelete);
        when(gymStorage.getTrainees()).thenReturn(trainees);

        traineeDAO.delete(traineeId);

        assertNull(trainees.get(traineeId));
    }

    @Test
    public void testDelete_TraineeDoesNotExist() {
        int traineeId = 2;
        Map<Integer, Trainee> trainees = new HashMap<>();
        when(gymStorage.getTrainees()).thenReturn(trainees);

        traineeDAO.delete(traineeId);

        assertNull(trainees.get(traineeId));
    }

    @Test
    public void testUpdate_TraineeExists() {
        int traineeId = 1;
        String newUsername = "updated_username";
        Trainee existingTrainee = new Trainee("John", "Doe", null, null, traineeId);
        Map<Integer, Trainee> trainees = new HashMap<>();
        trainees.put(traineeId, existingTrainee);
        when(gymStorage.getTrainees()).thenReturn(trainees);

        Trainee updatedTrainee = new Trainee("John", "Doe", null, null, traineeId);
        updatedTrainee.setUsername(newUsername);

        traineeDAO.update(updatedTrainee);

        assertEquals(newUsername, trainees.get(traineeId).getUsername());
    }
}
