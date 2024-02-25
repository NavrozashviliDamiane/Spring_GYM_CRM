package org.example.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trainer extends User {
    private String specialization;
    private Integer userId;

    public Trainer(String firstName, String lastName, String specialization, Integer userId) {
        super(firstName, lastName);
        this.specialization = specialization;
        this.userId = userId;

    }
}
