package org.example;

import org.example.config.AppConfig;
import org.example.facade.GymFacade;
import org.example.model.Trainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the GymFacade bean
        GymFacade gymFacade = context.getBean(GymFacade.class);

        // Create a new Trainer
        Trainer trainer = new Trainer("John", "Doe", "Personal Training");
        gymFacade.createTrainer(trainer);

        // Display the created Trainer
        Trainer createdTrainer = gymFacade.findTrainerById(trainer.getUserId());
        System.out.println("Created Trainer:");
        System.out.println("ID: " + createdTrainer.getUserId());
        System.out.println("First Name: " + createdTrainer.getFirstName());
        System.out.println("Last Name: " + createdTrainer.getLastName());
        System.out.println("Specialization: " + createdTrainer.getSpecialization());
        System.out.println("Username: " + createdTrainer.getUsername());
        System.out.println("Password: " + createdTrainer.getPassword());
    }
}
