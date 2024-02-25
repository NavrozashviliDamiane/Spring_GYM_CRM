package org.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.Logger;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class GymStorage {

    @Autowired
    private Logger logger;

    @Autowired
    public void GymStorage(Logger logger) {
        this.logger = logger;
    }

    @Value("${data.file.path}")
    private Resource dataFile;

    private Map<Integer, Trainer> trainers = new HashMap<>();
    private Map<Integer, Trainee> trainees = new HashMap<>();
    private Map<Integer, Training> trainings = new HashMap<>();

    @PostConstruct
    public void initialize() {
        logger.info("Initializing GymStorage...");
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        try {
            logger.info("Loading data from file...");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonData = objectMapper.readValue(dataFile.getFile(), Map.class);

            List<Map<String, Object>> traineeList = (List<Map<String, Object>>) jsonData.get("trainees");
            for (Map<String, Object> traineeData : traineeList) {
                Trainee trainee = new Trainee();
                trainee.setUserId((Integer) traineeData.get("userId"));
                trainee.setFirstName((String) traineeData.get("firstName"));
                trainee.setLastName((String) traineeData.get("lastName"));
                trainees.put(trainee.getUserId(), trainee);
            }

            List<Map<String, Object>> trainerList = (List<Map<String, Object>>) jsonData.get("trainers");
            for (Map<String, Object> trainerData : trainerList) {
                Trainer trainer = new Trainer();
                trainer.setUserId((Integer) trainerData.get("userId"));
                trainer.setFirstName((String) trainerData.get("firstName"));
                trainer.setLastName((String) trainerData.get("lastName"));
                trainers.put(trainer.getUserId(), trainer);
            }
        } catch (IOException e) {
            logger.error("Error loading data from file: {}", e.getMessage());
        }
    }

    public boolean trainerUsernameExists(String username) {
        logger.debug("Checking if trainer username '{}' exists", username);
        for (Trainer trainer : trainers.values()) {
            if (trainer.getUsername() != null && trainer.getUsername().equals(username)) {
                logger.debug("Trainer username '{}' exists", username);
                return true;
            }
        }
        logger.debug("Trainer username '{}' does not exist", username);
        return false;
    }

    public boolean traineeUsernameExists(String username) {
        logger.debug("Checking if trainee username '{}' exists", username);

        for (Trainee trainee : trainees.values()) {
            if (trainee.getUsername() != null && trainee.getUsername().equals(username)) {
                logger.debug("Trainee username '{}' exists", username);
                return true;
            }
        }
        logger.debug("Trainee username '{}' does not exist", username);
        return false;
    }
}
