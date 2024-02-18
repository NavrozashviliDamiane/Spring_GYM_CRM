package org.example.dao;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TrainingDAO {

    private final Map<Integer, Training> trainingMap;

    @Autowired
    public TrainingDAO(Map<Integer, Training> trainingMap) {
        this.trainingMap = trainingMap;
    }

    // Save a new Training
    public void saveTraining(Training training) {
        trainingMap.put(training.getId(), training);
    }

    // Retrieve a Training by id
    public Training getTrainingById(int id) {
        return trainingMap.get(id);
    }

    // Update an existing Training
    public void updateTraining(Training training) {
        if (trainingMap.containsKey(training.getId())) {
            trainingMap.put(training.getId(), training);
        } else {
            throw new IllegalArgumentException("Training with id " + training.getId() + " does not exist");
        }
    }

    // Delete a Training by id
    public void deleteTraining(int id) {
        trainingMap.remove(id);
    }
}
