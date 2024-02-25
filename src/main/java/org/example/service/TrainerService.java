package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.TrainerDAO;
import org.example.model.Trainer;
import org.example.util.PasswordGenerator;
import org.example.util.UsernameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Autowired
    private UsernameGenerator usernameGenerator;

    private static final Logger logger = LogManager.getLogger(TrainerService.class);

    @Autowired
    private TrainerDAO trainerDAO;

    public Trainer findTrainerById(Integer id) {
        return trainerDAO.findById(id);
    }

    public void createTrainer(Trainer trainer) {
        String username = usernameGenerator.generateUsername(trainer.getFirstName(), trainer.getLastName(), trainer);
        trainer.setUsername(username);

        String password = passwordGenerator.generatePassword();
        trainer.setPassword(password);

        trainerDAO.save(trainer);

        logger.info("Trainer created: {}", trainer);
    }

    public void updateTrainer(Trainer trainer) {
        trainerDAO.update(trainer);
        logger.info("Trainer updated: {}", trainer);
    }

    public void deleteTrainer(Integer id) {
        Trainer trainer = trainerDAO.findById(id);
        if (trainer != null) {
            trainerDAO.delete(id);
            logger.info("Trainer deleted: {}", trainer);
        } else {
            logger.warn("Trainer with ID {} not found for deletion", id);
        }
    }
}
