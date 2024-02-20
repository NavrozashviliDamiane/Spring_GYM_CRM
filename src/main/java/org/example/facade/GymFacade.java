package org.example.facade;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Trainee findTraineeById(Integer id) {
        return traineeService.findTraineeById(id);
    }

    public void createTrainee(Trainee trainee) {
        traineeService.createTrainee(trainee);
    }

    public void updateTrainee(Trainee trainee) {
        traineeService.updateTrainee(trainee);
    }

    public void deleteTrainee(Integer id) {
        traineeService.deleteTrainee(id);
    }

    public Trainer findTrainerById(Integer id) {
        return trainerService.findTrainerById(id);
    }

    public void createTrainer(Trainer trainer) {
        trainerService.createTrainer(trainer);
    }

    public void updateTrainer(Trainer trainer) {
        trainerService.updateTrainer(trainer);
    }

    public void deleteTrainer(Integer id) {
        trainerService.deleteTrainer(id);
    }

    public List<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }
}

