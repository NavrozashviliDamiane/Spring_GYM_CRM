package org.example;

import org.apache.logging.log4j.Logger;
import org.example.facade.GymFacade;
import org.example.model.Trainee;
import org.example.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class MainTest {

    @Mock
    private Logger logger;

    @Mock
    private GymFacade gymFacade;

    @InjectMocks
    private Main main;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRun() {
        Trainer trainer1 = new Trainer("John", "Doe", "Strength Training", 1);
        Trainer trainer2 = new Trainer("John", "Doe", "Strength Training", 2);
        doNothing().when(gymFacade).createTrainer(trainer1);
        doNothing().when(gymFacade).createTrainer(trainer2);

        LocalDate dateOfBirth = LocalDate.of(2000, 5, 15);
        Trainee trainee1 = new Trainee("Alice", "Smith", dateOfBirth, "123 Maple Street", 1);
        Trainee trainee2 = new Trainee("Alice", "Smith", dateOfBirth, "123 Maple Street", 2);
        doNothing().when(gymFacade).createTrainee(trainee1);
        doNothing().when(gymFacade).createTrainee(trainee2);

        main.run();

        verify(gymFacade, times(2)).createTrainer(any(Trainer.class));
        verify(gymFacade, times(2)).createTrainee(any(Trainee.class));
        verify(logger, atLeastOnce()).info(anyString(), any(Object.class));
    }
}
