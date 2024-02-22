package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.TrainingDAO;
import org.example.model.Training;
import org.example.model.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {

    private static final Logger logger = LogManager.getLogger(TrainingService.class);

    @Autowired
    private TrainingDAO trainingDAO;

    public void createTraining(Integer traineeId, Integer trainerId, String trainingName, TrainingType trainingType, LocalDate trainingDate, Integer trainingDuration) {
        if (traineeId == null || trainerId == null || trainingName == null || trainingType == null || trainingDate == null || trainingDuration == null) {
            throw new IllegalArgumentException("All parameters must be provided");
        }

        Training training = new Training(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);

        trainingDAO.create(training);

        logger.info("Training created: Name={}, Type={}, Date={}, Duration={}",
                trainingName, trainingType, trainingDate, trainingDuration);
    }

    public List<Training> getAllTrainings() {
        logger.info("Retrieving all trainings");
        return trainingDAO.selectAll();
    }
}
