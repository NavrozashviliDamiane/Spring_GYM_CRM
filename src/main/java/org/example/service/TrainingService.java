package org.example.service;


import org.example.dao.TrainingDAO;
import org.example.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;

    public List<Training> getAllTrainings() {
        return trainingDAO.selectAll();
    }
}

