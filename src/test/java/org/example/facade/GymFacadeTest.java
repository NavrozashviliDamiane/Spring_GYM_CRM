package org.example.facade;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.model.TrainingType;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GymFacadeTest {

    @Mock
    private TraineeService traineeService;

    @Mock
    private TrainerService trainerService;

    @Mock
    private TrainingService trainingService;

    @InjectMocks
    private GymFacade gymFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindTraineeById() {
        Trainee trainee = new Trainee();
        trainee.setUserId(1);
        when(traineeService.findTraineeById(1)).thenReturn(trainee);

        Trainee foundTrainee = gymFacade.findTraineeById(1);

        assertEquals(trainee, foundTrainee);
        verify(traineeService, times(1)).findTraineeById(1);
    }

    @Test
    void testCreateTrainee() {
        Trainee trainee = new Trainee();

        gymFacade.createTrainee(trainee);

        verify(traineeService, times(1)).createTrainee(trainee);
    }

    @Test
    void testUpdateTrainee() {
        Trainee trainee = new Trainee();

        gymFacade.updateTrainee(trainee);

        verify(traineeService, times(1)).updateTrainee(trainee);
    }

    @Test
    void testDeleteTrainee() {
        Integer traineeId = 1;

        gymFacade.deleteTrainee(traineeId);

        verify(traineeService, times(1)).deleteTrainee(traineeId);
    }

    @Test
    void testFindTrainerById() {
        Trainer trainer = new Trainer();
        trainer.setUserId(1);
        when(trainerService.findTrainerById(1)).thenReturn(trainer);

        Trainer foundTrainer = gymFacade.findTrainerById(1);

        assertEquals(trainer, foundTrainer);
        verify(trainerService, times(1)).findTrainerById(1);
    }

    @Test
    void testCreateTrainer() {
        Trainer trainer = new Trainer();

        gymFacade.createTrainer(trainer);

        verify(trainerService, times(1)).createTrainer(trainer);
    }

    @Test
    void testUpdateTrainer() {
        Trainer trainer = new Trainer();

        gymFacade.updateTrainer(trainer);

        verify(trainerService, times(1)).updateTrainer(trainer);
    }

    @Test
    void testDeleteTrainer() {
        Integer trainerId = 1;

        gymFacade.deleteTrainer(trainerId);

        verify(trainerService, times(1)).deleteTrainer(trainerId);
    }

    @Test
    void testGetAllTrainings() {
        List<Training> trainings = new ArrayList<>();
        when(trainingService.getAllTrainings()).thenReturn(trainings);

        List<Training> result = gymFacade.getAllTrainings();

        assertEquals(trainings, result);
        verify(trainingService, times(1)).getAllTrainings();
    }

    @Test
    void testCreateTraining() {
        Integer traineeId = 1;
        Integer trainerId = 2;
        String trainingName = "Test Training";
        TrainingType trainingType = TrainingType.CARDIO;
        LocalDate trainingDate = LocalDate.now();
        Integer trainingDuration = 60;

        gymFacade.createTraining(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);

        verify(trainingService, times(1)).createTraining(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);
    }
}
