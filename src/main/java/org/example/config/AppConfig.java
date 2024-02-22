package org.example.config;

import org.apache.logging.log4j.LogManager;
import org.example.dao.*;
import org.example.service.*;
import org.example.storage.GymStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.apache.logging.log4j.Logger;



@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public Logger logger() {
        return LogManager.getLogger(getClass());
    }

    @Bean
    public GymStorage gymStorage() {
        Logger logger = this.logger();
        logger.info("Initializing GymStorage bean...");
        return new GymStorage();

    }

    @Bean
    public TrainerDAO trainerDAO() {
        Logger logger = this.logger();
        logger.info("Initializing TrainerDAO bean...");
        return new TrainerDAOImpl();
    }

    @Bean
    public TraineeDAO traineeDAO() {
        Logger logger = this.logger();
        logger.info("Initializing TraineeDAO bean...");
        return new TraineeDAOImpl();
    }

    @Bean
    public TrainingDAO trainingDAO() {
        Logger logger = this.logger();
        logger.info("Initializing TrainingDAO bean...");
        return new TrainingDAOImpl();
    }

    @Bean
    public TrainerService trainerService() {
        Logger logger = this.logger();
        logger.info("Initializing TrainerService bean...");
        return new TrainerService();
    }

    @Bean
    public TraineeService traineeService() {
        Logger logger = this.logger();
        logger.info("Initializing TraineeService bean...");
        return new TraineeService();
    }

    @Bean
    public TrainingService trainingService() {
        Logger logger = this.logger();
        logger.info("Initializing TrainingService bean...");
        return new TrainingService();
    }
}

