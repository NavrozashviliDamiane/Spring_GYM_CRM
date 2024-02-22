package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trainee extends User {
    private LocalDate dateOfBirth;
    private String address;
    private Integer userId;

    public Trainee(String firstName, String lastName, LocalDate dateOfBirth, String address, Integer userId) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.userId = userId;

    }

}
