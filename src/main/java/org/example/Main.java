package org.example;

import org.apache.logging.log4j.Logger;
import org.example.config.AppConfig;
import org.example.facade.GymFacade;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Main {

    private final Logger logger;

    @Autowired
    public Main(Logger logger) {
        this.logger = logger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Main main = context.getBean(Main.class);
        main.run();
    }

    public void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        GymFacade gymFacade = context.getBean(GymFacade.class);

        Trainer newTrainer = new Trainer("John", "Doe", "Strength Training");
        gymFacade.createTrainer(newTrainer);
        logger.info("New Trainer created: {}", newTrainer);

        Trainer newTrainer2 = new Trainer("John", "Doe", "Strength Training");
        gymFacade.createTrainer(newTrainer2);
        logger.info("New Trainer created: {}", newTrainer2);

        LocalDate dateOfBirth = LocalDate.of(2000, 5, 15);
        Trainee newTrainee = new Trainee("Alice", "Smith", dateOfBirth, "123 Maple Street", 1);
        gymFacade.createTrainee(newTrainee);
        logger.info("New Trainee created: {}", newTrainee);

        Trainee newTrainee2 = new Trainee("Alice", "Smith", dateOfBirth, "123 Maple Street", 2);
        gymFacade.createTrainee(newTrainee2);
        logger.info("New Trainee created: {}", newTrainee2);

        Trainee foundTrainee = gymFacade.findTraineeById(1);
        if (foundTrainee != null) {
            logger.info("Found Trainee: {}", foundTrainee);
        } else {
            logger.info("Trainee not found with the given ID.");
        }

        Integer traineeId = 1;
        Integer trainerId = 1;
        String trainingName = "Strength Training";
        TrainingType trainingType = TrainingType.WEIGHT_TRAINING;
        LocalDate trainingDate = LocalDate.now();
        Integer trainingDuration = 60;

        gymFacade.createTraining(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);
        logger.info("Training created: Name={}, Type={}, Date={}, Duration={}",
                trainingName, trainingType, trainingDate, trainingDuration);
    }
}
