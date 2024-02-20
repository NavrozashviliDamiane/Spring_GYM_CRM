package org.example.service;


import org.example.dao.TrainerDAO;
import org.example.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerDAO trainerDAO;

    public Trainer findTrainerById(Integer id) {
        return trainerDAO.findById(id);
    }

    public void createTrainer(Trainer trainer) {
        trainerDAO.save(trainer);
    }

    public void updateTrainer(Trainer trainer) {
        trainerDAO.update(trainer);
    }

    public void deleteTrainer(Integer id) {
        trainerDAO.delete(id);
    }


}
