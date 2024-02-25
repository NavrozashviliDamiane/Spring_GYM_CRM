package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.example.dao.TrainingDAO;
import org.example.model.Training;
import org.example.model.TrainingType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainingServiceTest {

    @Mock
    private TrainingDAO trainingDAO;

    @InjectMocks
    private TrainingService trainingService;

    @Test
    void testCreateTraining_ValidInput() {
        Integer traineeId = 1;
        Integer trainerId = 2;
        String trainingName = "Strength Training";
        TrainingType trainingType = TrainingType.WEIGHT_TRAINING;
        LocalDate trainingDate = LocalDate.now();
        Integer trainingDuration = 60;

        assertDoesNotThrow(() -> trainingService.createTraining(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration));

        verify(trainingDAO).create(any(Training.class));
    }

    @Test
    void testCreateTraining_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> trainingService.createTraining(null, null, null, null, null, null));
        verifyNoInteractions(trainingDAO);
    }

    @Test
    void testCreateTraining_NullTraineeId() {
        Integer trainerId = 2;
        String trainingName = "Strength Training";
        TrainingType trainingType = TrainingType.WEIGHT_TRAINING;
        LocalDate trainingDate = LocalDate.now();
        Integer trainingDuration = 60;

        assertThrows(IllegalArgumentException.class, () -> trainingService.createTraining(null, trainerId, trainingName, trainingType, trainingDate, trainingDuration));
        verifyNoInteractions(trainingDAO);
    }

    @Test
    void testGetAllTrainings() {
        List<Training> expectedTrainings = new ArrayList<>();
        when(trainingDAO.selectAll()).thenReturn(expectedTrainings);

        List<Training> actualTrainings = trainingService.getAllTrainings();

        assertEquals(expectedTrainings, actualTrainings);
    }

    @Test
    void testCreateTraining_NullParameter() {
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(null, 1, "Training", TrainingType.WEIGHT_TRAINING, LocalDate.now(), 60));
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(1, null, "Training", TrainingType.WEIGHT_TRAINING, LocalDate.now(), 60));
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(1, 2, null, TrainingType.WEIGHT_TRAINING, LocalDate.now(), 60));
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(1, 2, "Training", null, LocalDate.now(), 60));
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(1, 2, "Training", TrainingType.WEIGHT_TRAINING, null, 60));
        assertThrows(IllegalArgumentException.class, () ->
                trainingService.createTraining(1, 2, "Training", TrainingType.WEIGHT_TRAINING, LocalDate.now(), null));

        verifyNoInteractions(trainingDAO);
    }
}
