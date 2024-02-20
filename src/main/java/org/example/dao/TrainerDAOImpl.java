package org.example.dao;

import org.example.model.Trainer;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerDAOImpl implements TrainerDAO {

    @Autowired
    private GymStorage gymStorage;

    @Override
    public Trainer findById(Integer id) {
        return gymStorage.getTrainers().get(id);
    }

    @Override
    public void save(Trainer trainer) {
        gymStorage.getTrainers().put(trainer.getUserId(), trainer);
    }

    @Override
    public void update(Trainer trainer) {
        gymStorage.getTrainers().put(trainer.getUserId(), trainer);
    }

    @Override
    public void delete(Integer id) {
        gymStorage.getTrainers().remove(id);
    }
}

