package org.example.dao;

import org.example.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TraineeDAO {

    private final Map<Integer, Trainee> traineeMap;

    @Autowired
    public TraineeDAO(Map<Integer, Trainee> traineeMap) {
        this.traineeMap = traineeMap;
    }

    // Save a new Trainee
    public void saveTrainee(Trainee trainee) {
        traineeMap.put(trainee.getUserId(), trainee);
    }

    // Retrieve a Trainee by userId
    public Trainee getTraineeById(Integer userId) {
        return traineeMap.get(userId);
    }

    // Update an existing Trainee
    public void updateTrainee(Trainee trainee) {
        if (traineeMap.containsKey(trainee.getUserId())) {
            traineeMap.put(trainee.getUserId(), trainee);
        } else {
            throw new IllegalArgumentException("Trainee with userId " + trainee.getUserId() + " does not exist");
        }
    }

    // Delete a Trainee by userId
    public void deleteTrainee(int userId) {
        traineeMap.remove(userId);
    }
}

