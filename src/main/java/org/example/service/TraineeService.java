package org.example.service;

import org.example.dao.TraineeDAO;
import org.example.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TraineeService {

    private final TraineeDAO traineeDAO;

    @Autowired
    public TraineeService(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public void createTrainee(Trainee trainee) {
        traineeDAO.saveTrainee(trainee);
    }

    public void updateTrainee(Trainee trainee) {
        traineeDAO.updateTrainee(trainee);
    }

    public void deleteTrainee(int id) {
        traineeDAO.deleteTrainee(id);
    }

    public Trainee getTrainee(int id) {
        return traineeDAO.getTraineeById(id);
    }

}
