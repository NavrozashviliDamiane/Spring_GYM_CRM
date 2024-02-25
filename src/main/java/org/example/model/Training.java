package org.example.model;

import lombok.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    private Integer traineeId;
    private Integer trainerId;
    private String trainingName;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private Integer trainingDuration;

}
