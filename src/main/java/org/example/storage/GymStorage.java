package org.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@Component
public class GymStorage {

    @Value("${data.file.path}")
    private Resource dataFile;


    private Map<Integer, Trainer> trainers = new HashMap<>();
    private Map<Integer, Trainee> trainees = new HashMap<>();
    private Map<Integer, Training> trainings = new HashMap<>();


    @PostConstruct
    public void initialize() {
        loadDataFromFile();
    }


    private void loadDataFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Training> trainingList = Arrays.asList(objectMapper.readValue(dataFile.getFile(), Training[].class));
            for (Training training : trainingList) {
                // Add objects to storage maps
                trainees.put(training.getTraineeId(), new Trainee());
                trainers.put(training.getTrainerId(), new Trainer());
                trainings.put(training.getTraineeId(), training);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean usernameExists(String username) {
        // Check if the username exists in trainers or trainees
        for (Trainer trainer : trainers.values()) {
            if (trainer.getUsername() != null && trainer.getUsername().equals(username)) {
                return true;
            }
        }
        for (Trainee trainee : trainees.values()) {
            if (trainee.getUsername() != null && trainee.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


}
