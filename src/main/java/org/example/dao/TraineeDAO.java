package org.example.dao;

import org.example.model.Trainee;

public interface TraineeDAO {
    Trainee findById(Integer id);

    void save(Trainee trainee);

    void update(Trainee trainee);

    void delete(Integer id);
}
