package org.example.service;

import org.example.dao.TraineeDAO;
import org.example.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {

    @Autowired
    private TraineeDAO traineeDAO;

    public Trainee findTraineeById(Integer id) {
        return traineeDAO.findById(id);
    }

    public void createTrainee(Trainee trainee) {
        traineeDAO.save(trainee);
    }

    public void updateTrainee(Trainee trainee) {
        traineeDAO.update(trainee);
    }

    public void deleteTrainee(Integer id) {
        traineeDAO.delete(id);
    }


}
