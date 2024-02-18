package org.example.config;

import org.example.dao.TraineeDAO;
import org.example.dao.TrainerDAO;
import org.example.dao.TrainingDAO;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.service.GymFacade;
import org.example.service.TraineeService;
import org.example.service.TrainerService;
import org.example.service.TrainingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;


@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {



    @Bean
    public TrainerDAO trainerDAO(Map<Integer, Trainer> trainerMap) {
        return new TrainerDAO(trainerMap);
    }

    @Bean
    public TraineeDAO traineeDAO(Map<Integer, Trainee> traineeMap) {
        return new TraineeDAO(traineeMap);
    }

    @Bean
    public TrainingDAO trainingDAO(Map<Integer, Training> trainingMap) {
        return new TrainingDAO(trainingMap);
    }

    @Bean
    public GymFacade gymFacade(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        return new GymFacade(traineeService, trainerService, trainingService);
    }

    @Bean
    public TraineeService traineeService(TraineeDAO traineeDAO) {
        return new TraineeService(traineeDAO);
    }

    @Bean
    public TrainerService trainerService(TrainerDAO trainerDAO) {
        return new TrainerService(trainerDAO);
    }

    @Bean
    public TrainingService trainingService(TrainingDAO trainingDAO) {
        return new TrainingService(trainingDAO);
    }
}
