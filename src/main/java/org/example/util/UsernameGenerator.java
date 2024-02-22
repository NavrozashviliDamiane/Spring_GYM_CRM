package org.example.util;

import org.apache.logging.log4j.Logger;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.User;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameGenerator {
    private static GymStorage gymStorage;

    private static Logger logger;

    @Autowired
    public void setGymStorage(GymStorage storage, Logger logger) {
        this.gymStorage = storage;
        this.logger = logger;
    }

    public static String generateUsername(String firstName, String lastName, User user) {
        logger.info("Generating username for user: {} {}", firstName, lastName);

        String baseUsername = firstName + "." + lastName;

        if (user instanceof Trainer) {
            if (gymStorage != null) {
                if (gymStorage.trainerUsernameExists(baseUsername)) {
                    int serialNumber = 1;
                    while (gymStorage.trainerUsernameExists(baseUsername + serialNumber)) {
                        serialNumber++;
                    }
                    return baseUsername + serialNumber;
                } else {
                    Trainer trainer = (Trainer) user;
                    trainer.setUsername(baseUsername);
                    logger.info("Username set as: {}", baseUsername);
                    return baseUsername;
                }
            } else {
                logger.error("Gym storage is not initialized");
                throw new IllegalStateException("Gym storage is not initialized");
            }
        } else if (user instanceof Trainee) {
            if (gymStorage != null) {
                if (gymStorage.traineeUsernameExists(baseUsername)) {
                    int serialNumber = 1;
                    while (gymStorage.traineeUsernameExists(baseUsername + serialNumber)) {
                        serialNumber++;
                    }
                    return baseUsername + serialNumber;
                } else {
                    Trainee trainee = (Trainee) user;
                    trainee.setUsername(baseUsername);
                    logger.info("Username set as: {}", baseUsername);
                    return baseUsername;
                }
            } else {
                logger.error("Gym storage is not initialized");
                throw new IllegalStateException("Gym storage is not initialized");
            }
        } else {
            logger.error("Gym storage is not initialized");
            throw new IllegalArgumentException("User must be an instance of Trainer or Trainee");
        }
    }
}
