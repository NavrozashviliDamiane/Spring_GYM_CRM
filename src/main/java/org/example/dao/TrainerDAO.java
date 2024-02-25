package org.example.dao;

import org.example.model.Trainer;

public interface TrainerDAO {
    Trainer findById(Integer id);

    void save(Trainer trainer);

    void update(Trainer trainer);

    void delete(Integer id);
}
