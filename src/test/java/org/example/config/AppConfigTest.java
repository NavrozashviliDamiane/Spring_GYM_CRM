package org.example.config;

import org.example.dao.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class AppConfigTest {

    @Test
    void testBeansInitialization() {
        AppConfig appConfig = new AppConfig();
        assertNotNull(appConfig.logger());
        assertNotNull(appConfig.gymStorage());
        assertNotNull(appConfig.trainerDAO());
        assertNotNull(appConfig.traineeDAO());
        assertNotNull(appConfig.trainingDAO());

        TrainerDAO trainerDAO = mock(TrainerDAO.class);
        TraineeDAO traineeDAO = mock(TraineeDAO.class);
        TrainingDAO trainingDAO = mock(TrainingDAO.class);

        assertNotNull(appConfig.trainerService());
        assertNotNull(appConfig.traineeService());
        assertNotNull(appConfig.trainingService());
    }
}
