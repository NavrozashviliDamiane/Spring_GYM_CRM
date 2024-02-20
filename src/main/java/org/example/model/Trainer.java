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

    public Trainer(String firstName, String lastName, String specialization) {
        super(firstName, lastName); // Call the constructor of the parent class
        this.specialization = specialization;
    }

}
