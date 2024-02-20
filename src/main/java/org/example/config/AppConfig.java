package org.example.config;

import org.example.dao.*;
import org.example.service.*;
import org.example.storage.GymStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public GymStorage gymStorage() {
        return new GymStorage();
    }

    @Bean
    public TrainerDAO trainerDAO() {
        return new TrainerDAOImpl();
    }

    @Bean
    public TraineeDAO traineeDAO() {
        return new TraineeDAOImpl();
    }

    @Bean
    public TrainingDAO trainingDAO() {
        return new TrainingDAOImpl();
    }

    @Bean
    public TrainerService trainerService() {
        return new TrainerService();
    }

    @Bean
    public TraineeService traineeService() {
        return new TraineeService();
    }

    @Bean
    public TrainingService trainingService() {
        return new TrainingService();
    }
}

