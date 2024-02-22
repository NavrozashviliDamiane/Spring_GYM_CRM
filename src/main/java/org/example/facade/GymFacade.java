package org.example.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.model.TrainingType;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class GymFacade {

    private static final Logger logger = LogManager.getLogger(GymFacade.class);

    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;

    @Autowired
    public GymFacade(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }

    public Trainee findTraineeById(Integer id) {
        logger.info("Finding trainee with ID: {}", id);
        return traineeService.findTraineeById(id);
    }

    public void createTrainee(Trainee trainee) {
        logger.info("Creating trainee: {}", trainee);
        traineeService.createTrainee(trainee);
    }

    public void updateTrainee(Trainee trainee) {
        logger.info("Updating trainee: {}", trainee);
        traineeService.updateTrainee(trainee);
    }

    public void deleteTrainee(Integer id) {
        logger.info("Deleting trainee with ID: {}", id);
        traineeService.deleteTrainee(id);
    }

    public Trainer findTrainerById(Integer id) {
        logger.info("Finding trainer with ID: {}", id);
        return trainerService.findTrainerById(id);
    }

    public void createTrainer(Trainer trainer) {
        logger.info("Creating trainer: {}", trainer);
        trainerService.createTrainer(trainer);
    }

    public void updateTrainer(Trainer trainer) {
        logger.info("Updating trainer: {}", trainer);
        trainerService.updateTrainer(trainer);
    }

    public void deleteTrainer(Integer id) {
        logger.info("Deleting trainer with ID: {}", id);
        trainerService.deleteTrainer(id);
    }

    public List<Training> getAllTrainings() {
        logger.info("Getting all trainings");
        return trainingService.getAllTrainings();
    }

    public void createTraining(Integer traineeId, Integer trainerId, String trainingName, TrainingType trainingType, LocalDate trainingDate, Integer trainingDuration) {
        logger.info("Creating training - Trainee ID: {}, Trainer ID: {}, Name: {}, Type: {}, Date: {}, Duration: {}",
                traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);
        trainingService.createTraining(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);
    }
}
