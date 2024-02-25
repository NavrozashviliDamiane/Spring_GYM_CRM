package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.example.dao.TrainerDAO;
import org.example.model.Trainer;
import org.example.service.TrainerService;
import org.example.util.PasswordGenerator;
import org.example.util.UsernameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainerServiceTest {

    @Mock
    private TrainerDAO trainerDAO;

    @Mock
    private PasswordGenerator passwordGenerator;

    @Mock
    private UsernameGenerator usernameGenerator;

    @InjectMocks
    private TrainerService trainerService;

    @Test
    void testCreateTrainer() {
        Trainer trainer = new Trainer("John", "Doe", "Strength Training", 1);

        when(usernameGenerator.generateUsername("John", "Doe", trainer))
                .thenReturn("john_doe");
        when(passwordGenerator.generatePassword()).thenReturn("password123");

        trainerService.createTrainer(trainer);

        verify(trainerDAO).save(trainer);
        assertEquals("john_doe", trainer.getUsername());
        assertEquals("password123", trainer.getPassword());
    }

    @Test
    void testFindTrainerById() {
        Trainer expectedTrainer = new Trainer("John", "Doe", "Strength Training", 1);
        when(trainerDAO.findById(1)).thenReturn(expectedTrainer);

        Trainer actualTrainer = trainerService.findTrainerById(1);

        assertEquals(expectedTrainer, actualTrainer);
    }

    @Test
    void testUpdateTrainer() {
        Trainer trainer = new Trainer("John", "Doe", "Strength Training", 1);

        trainerService.updateTrainer(trainer);

        verify(trainerDAO).update(trainer);
    }

    @Test
    void testDeleteTrainer() {
        Trainer trainer = new Trainer("John", "Doe", "Strength Training", 1);
        when(trainerDAO.findById(1)).thenReturn(trainer);

        trainerService.deleteTrainer(1);

        verify(trainerDAO).delete(1);
    }

    @Test
    void testDeleteTrainer_NotFound() {
        when(trainerDAO.findById(1)).thenReturn(null);

        trainerService.deleteTrainer(1);

        verify(trainerDAO, never()).delete(1);
    }
}
