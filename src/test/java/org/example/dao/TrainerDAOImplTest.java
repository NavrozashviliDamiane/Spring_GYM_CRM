package org.example.dao;

import org.example.model.Trainer;
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
class TrainerDAOImplTest {

    @Mock
    private TrainerDAOImpl trainerDAOImpl;

    @Mock
    private GymStorage gymStorage;

    @InjectMocks
    private TrainerDAOImpl trainerDAO;


    @Test
    public void testSave() {
        int trainerId = 1;
        String trainerUsername = "john_doe";
        Trainer trainerToSave = new Trainer();
        trainerToSave.setUserId(trainerId);
        trainerToSave.setUsername(trainerUsername);

        Map<Integer, Trainer> trainers = new HashMap<>();
        when(gymStorage.getTrainers()).thenReturn(trainers);

        trainerDAO.save(trainerToSave);

        assertEquals(1, trainers.size());
        assertEquals(trainerToSave, trainers.get(trainerId));
        verify(gymStorage).getTrainers();
    }

    @Test
    public void testFindById_ExistingTrainer() {
        Trainer expectedTrainer = new Trainer();
        expectedTrainer.setUserId(1);
        expectedTrainer.setUsername("John Doe");
        Map<Integer, Trainer> trainerMap = new HashMap<>();
        trainerMap.put(1, expectedTrainer);
        when(gymStorage.getTrainers()).thenReturn(trainerMap);

        Trainer actualTrainer = trainerDAO.findById(1);

        assertEquals(expectedTrainer, actualTrainer);
    }

    @Test
    public void testFindById_NonExistingTrainer() {
        Map<Integer, Trainer> trainerMap = new HashMap<>();
        when(gymStorage.getTrainers()).thenReturn(trainerMap);

        Trainer actualTrainer = trainerDAO.findById(2);

        assertEquals(null, actualTrainer);
    }

    @Test
    public void testDelete_TrainerExists() {
        int trainerId = 1;
        Map<Integer, Trainer> trainers = new HashMap<>();
        Trainer trainerToDelete = new Trainer();
        trainerToDelete.setUserId(trainerId);
        trainers.put(trainerId, trainerToDelete);
        when(gymStorage.getTrainers()).thenReturn(trainers);

        trainerDAO.delete(trainerId);

        assertNull(trainers.get(trainerId));
    }

    @Test
    public void testDelete_TrainerDoesNotExist() {
        int trainerId = 2;
        Map<Integer, Trainer> trainers = new HashMap<>();
        when(gymStorage.getTrainers()).thenReturn(trainers);

        trainerDAO.delete(trainerId);

        assertNull(trainers.get(trainerId));
    }

    @Test
    public void testUpdate_TrainerExists() {
        int trainerId = 1;
        String newUsername = "updated_username";
        Trainer existingTrainer = new Trainer();
        existingTrainer.setUserId(trainerId);
        existingTrainer.setUsername("original_username");
        Map<Integer, Trainer> trainers = new HashMap<>();
        trainers.put(trainerId, existingTrainer);
        when(gymStorage.getTrainers()).thenReturn(trainers);

        Trainer updatedTrainer = new Trainer();
        updatedTrainer.setUserId(trainerId);
        updatedTrainer.setUsername(newUsername);

        trainerDAO.update(updatedTrainer);

        assertEquals(newUsername, trainers.get(trainerId).getUsername());
    }
}
