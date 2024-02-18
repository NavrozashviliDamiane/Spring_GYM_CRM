package org.example.dao;

import org.example.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TrainerDAO {

    private final Map<Integer, Trainer> trainerMap;

    @Autowired
    public TrainerDAO(Map<Integer, Trainer> trainerMap) {
        this.trainerMap = trainerMap;
    }



    // Save a new Trainer
    public void saveTrainer(Trainer trainer) {
        trainerMap.put(trainer.getUserId(), trainer);
    }

    // Retrieve a Trainer by userId

    // Update an existing Trainer
    public void updateTrainer(Trainer trainer) {
        if (trainerMap.containsKey(trainer.getUserId())) {
            trainerMap.put(trainer.getUserId(), trainer);
        } else {
            throw new IllegalArgumentException("Trainer with userId " + trainer.getUserId() + " does not exist");
        }
    }

    // Delete a Trainer by userId
    public void deleteTrainer(Integer userId) {
        trainerMap.remove(userId);
    }
}
