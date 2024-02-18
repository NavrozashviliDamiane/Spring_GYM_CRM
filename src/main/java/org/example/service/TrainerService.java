package org.example.service;

import org.example.dao.TrainerDAO;
import org.example.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerDAO trainerDAO;

    @Autowired
    public TrainerService(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public void createTrainer(Trainer trainer) {
        trainerDAO.saveTrainer(trainer);
    }

    public void updateTrainer(Trainer trainer) {
        trainerDAO.updateTrainer(trainer);
    }



}

