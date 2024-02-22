package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.TraineeDAO;
import org.example.model.Trainee;
import org.example.util.UsernameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {

    private static final Logger logger = LogManager.getLogger(TraineeService.class);

    @Autowired
    private TraineeDAO traineeDAO;

    public Trainee findTraineeById(Integer id) {
        return traineeDAO.findById(id);
    }

    public void createTrainee(Trainee trainee) {
        String username = UsernameGenerator.generateUsername(trainee.getFirstName(), trainee.getLastName(), trainee);
        trainee.setUsername(username);

        traineeDAO.save(trainee);

        logger.info("Trainee created: {}", trainee);
    }

    public void updateTrainee(Trainee trainee) {
        traineeDAO.update(trainee);
        logger.info("Trainee updated: {}", trainee);
    }

    public void deleteTrainee(Integer id) {
        Trainee trainee = traineeDAO.findById(id);
        if (trainee != null) {
            traineeDAO.delete(id);
            logger.info("Trainee deleted: {}", trainee);
        } else {
            logger.warn("Trainee with ID {} not found for deletion", id);
        }
    }
}
