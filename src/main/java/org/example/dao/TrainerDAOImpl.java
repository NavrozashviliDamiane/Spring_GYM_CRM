package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Trainer;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerDAOImpl implements TrainerDAO {

    private static final Logger logger = LogManager.getLogger(TrainerDAOImpl.class);

    @Autowired
    private GymStorage gymStorage;

    @Override
    public Trainer findById(Integer id) {
        logger.info("Finding trainer with ID: {}", id);
        Trainer trainer = gymStorage.getTrainers().get(id);
        if (trainer == null) {
            logger.warn("Trainer with ID {} not found", id);
        } else {
            logger.info("Found trainer: {}", trainer);
        }
        return trainer;
    }

    @Override
    public void save(Trainer trainer) {
        logger.info("Saving trainer: {}", trainer);
        gymStorage.getTrainers().put(trainer.getUserId(), trainer);
        logger.info("Trainer saved successfully");
    }

    @Override
    public void update(Trainer trainer) {
        logger.info("Updating trainer: {}", trainer);
        gymStorage.getTrainers().put(trainer.getUserId(), trainer);
        logger.info("Trainer updated successfully");
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting trainer with ID: {}", id);
        gymStorage.getTrainers().remove(id);
        logger.info("Trainer deleted successfully");
    }
}
