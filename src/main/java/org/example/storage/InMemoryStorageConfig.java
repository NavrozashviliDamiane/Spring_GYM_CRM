package org.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Trainer;
import org.example.model.Trainee;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class InMemoryStorageConfig {

    @Value("${storage.data.file}")
    private String dataFilePath;

    // Initialize storage bean with prepared data from file
    @Bean
    public Map<Integer, Object> inMemoryStorage() throws IOException {
        // Create ObjectMapper to deserialize JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Load data from JSON file and populate storage map
        Map<Integer, Object> storageMap = new HashMap<>();
        File file = new File(dataFilePath);
        if (file.exists()) {
            // Deserialize JSON data into map
            storageMap = objectMapper.readValue(file, HashMap.class);
        }

        return storageMap;
    }

    @Bean
    public Map<Integer, Trainer> trainerMap() throws IOException {
        // Create ObjectMapper to deserialize JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Load data from JSON file and populate trainer map
        Map<Integer, Trainer> trainerMap = new HashMap<>();
        File file = new File(dataFilePath);
        if (file.exists()) {
            // Deserialize JSON data into map
            trainerMap = objectMapper.readValue(file, HashMap.class);
        }

        return trainerMap;
    }


    @Bean
    public Map<Integer, Training> trainingMap() throws IOException {
        // Create ObjectMapper to deserialize JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Load data from JSON file and populate trainer map
        Map<Integer, Training> trainingMap = new HashMap<>();
        File file = new File(dataFilePath);
        if (file.exists()) {
            // Deserialize JSON data into map
            trainingMap = objectMapper.readValue(file, HashMap.class);
        }

        return trainingMap;
    }

    @Bean
    public Map<Integer, Trainee> traineeMap() throws IOException {
        // Create ObjectMapper to deserialize JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Load data from JSON file and populate trainer map
        Map<Integer, Trainee> traineeMap = new HashMap<>();
        File file = new File(dataFilePath);
        if (file.exists()) {
            // Deserialize JSON data into map
            traineeMap = objectMapper.readValue(file, HashMap.class);
        }

        return traineeMap;
    }

}


