package org.example.service;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymFacade {

    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;

    @Autowired
    public GymFacade(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }

    public void createTraineeProfile(Trainee trainee) {
        traineeService.createTrainee(trainee);
    }

    public void updateTrainerProfile(Trainer trainer) {
        trainerService.updateTrainer(trainer);
    }

    public Training getTrainingDetails(int trainingId) {
        return trainingService.getTraining(trainingId);
    }
}
