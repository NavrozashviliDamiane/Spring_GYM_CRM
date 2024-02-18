package org.example;

import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.example.service.GymFacade;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.config.AppConfig;
import org.example.service.TrainerService;
import org.example.service.TraineeService;
import org.example.service.TrainingService;

public class Main {

    public static void main(String[] args) {
        // Load the Spring application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.example");
        context.refresh();

        // Get the GymFacade bean from the context
        GymFacade gymFacade = context.getBean(GymFacade.class);

        // Fetch training details
        Training training = gymFacade.getTrainingDetails(1); // Assuming training with ID 1 exists

        if (training != null) {
            // Display training details
            System.out.println("Training Name: " + training.getTrainingName());
            System.out.println("Training Type: " + training.getTrainingType());
            System.out.println("Training Date: " + training.getTrainingDate());
            System.out.println("Training Duration: " + training.getTrainingDuration() + " minutes");
        } else {
            System.out.println("Training not found.");
        }

        // Close the application context
        context.close();
    }
}
