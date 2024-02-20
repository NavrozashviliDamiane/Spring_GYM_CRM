package org.example.dao;

import org.example.model.Training;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingDAOImpl implements TrainingDAO {

    @Autowired
    private GymStorage gymStorage;

//    @Override
//    public void create(Training training) {
//        gymStorage.getTrainings().put(gymStorage.getNextTrainingId(), training);
//        gymStorage.incrementNextTrainingId();
//    }

    @Override
    public List<Training> selectAll() {
        return new ArrayList<>(gymStorage.getTrainings().values());
    }
}

