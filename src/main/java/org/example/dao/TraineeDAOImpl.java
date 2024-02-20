package org.example.dao;

import org.example.model.Trainee;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TraineeDAOImpl implements TraineeDAO {

    @Autowired
    private GymStorage gymStorage;

    @Override
    public Trainee findById(Integer id) {
        return gymStorage.getTrainees().get(id);
    }

    @Override
    public void save(Trainee trainee) {
        gymStorage.getTrainees().put(trainee.getUserId(), trainee);
    }

    @Override
    public void update(Trainee trainee) {
        gymStorage.getTrainees().put(trainee.getUserId(), trainee);
    }

    @Override
    public void delete(Integer id) {
        gymStorage.getTrainees().remove(id);
    }
}
