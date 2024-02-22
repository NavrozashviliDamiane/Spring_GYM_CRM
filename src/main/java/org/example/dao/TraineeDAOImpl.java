package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Trainee;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TraineeDAOImpl implements TraineeDAO {

    private static final Logger logger = LogManager.getLogger(TraineeDAOImpl.class);

    @Autowired
    private GymStorage gymStorage;

    @Override
    public Trainee findById(Integer id) {
        logger.info("Finding trainee with ID: {}", id);
        Trainee trainee = gymStorage.getTrainees().get(id);
        if (trainee == null) {
            logger.warn("Trainee with ID {} not found", id);
        } else {
            logger.info("Found trainee: {}", trainee);
        }
        return trainee;
    }

    @Override
    public void save(Trainee trainee) {
        logger.info("Saving trainee: {}", trainee);
        gymStorage.getTrainees().put(trainee.getUserId(), trainee);
        logger.info("Trainee saved successfully");
    }

    @Override
    public void update(Trainee trainee) {
        logger.info("Updating trainee: {}", trainee);
        gymStorage.getTrainees().put(trainee.getUserId(), trainee);
        logger.info("Trainee updated successfully");
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting trainee with ID: {}", id);
        gymStorage.getTrainees().remove(id);
        logger.info("Trainee deleted successfully");
    }
}
