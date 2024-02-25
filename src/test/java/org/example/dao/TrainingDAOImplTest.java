package org.example.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Training;
import org.example.storage.GymStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.model.TrainingType;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainingDAOImplTest {

    @Mock
    private GymStorage gymStorage;

    @InjectMocks
    private TrainingDAOImpl trainingDAO;

    @Test
    public void testCreate() {
        int traineeId = 1;
        int trainerId = 2;
        String trainingName = "Strength Training";
        TrainingType trainingType = TrainingType.YOGA;
        LocalDate trainingDate = LocalDate.of(2024, 2, 24);
        int trainingDuration = 60;
        Training trainingToCreate = new Training(traineeId, trainerId, trainingName, trainingType, trainingDate, trainingDuration);

        Map<Integer, Training> trainingsMap = new HashMap<>();
        when(gymStorage.getTrainings()).thenReturn(trainingsMap);

        trainingDAO.create(trainingToCreate);

        assertEquals(1, trainingsMap.size());
        assertTrue(trainingsMap.containsValue(trainingToCreate));
    }

    @Test
    public void testSelectAll() {
        Training training1 = new Training(1, 2, "Strength Training", TrainingType.YOGA, LocalDate.of(2024, 2, 1), 60);
        Training training2 = new Training(3, 4, "Cardio Workout", TrainingType.CARDIO, LocalDate.of(2024, 2, 2), 45);
        List<Training> expectedTrainings = List.of(training1, training2);

        Map<Integer, Training> trainings = new HashMap<>();
        trainings.put(training1.hashCode(), training1);
        trainings.put(training2.hashCode(), training2);
        when(gymStorage.getTrainings()).thenReturn(trainings);

        List<Training> selectedTrainings = trainingDAO.selectAll();

        assertEquals(expectedTrainings.size(), selectedTrainings.size());
        assertTrue(selectedTrainings.containsAll(expectedTrainings));
    }
}
