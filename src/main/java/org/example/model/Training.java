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
    private Integer id;
    private Integer traineeId;
    private Integer trainerId;
    private String trainingName;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private Integer trainingDuration; // Duration in minutes

    public Integer getId() {
        return id;
    }
}
