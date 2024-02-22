package org.example.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Training;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingDAOImpl implements TrainingDAO {

    private static final Logger logger = LogManager.getLogger(TrainingDAOImpl.class);

    @Autowired
    private GymStorage gymStorage;

    @Override
    public void create(Training training) {
        gymStorage.getTrainings().put(trainingKey(training), training);
        logger.info("Training created: {}", training);
    }

    private Integer trainingKey(Training training) {
        return training.getTraineeId().hashCode() ^ training.getTrainerId().hashCode() ^ training.getTrainingDate().hashCode();
    }

    @Override
    public List<Training> selectAll() {
        List<Training> allTrainings = new ArrayList<>(gymStorage.getTrainings().values());
        logger.info("Retrieved all trainings: {}", allTrainings);
        return allTrainings;
    }
}
