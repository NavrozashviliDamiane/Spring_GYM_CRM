package org.example.model;

import lombok.*;
import org.example.util.PasswordGenerator;
import org.example.util.UsernameGenerator;


@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean isActive;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        generateUsername();
        generatePassword();
    }

    private void generateUsername() {
        username = UsernameGenerator.generateUsername(firstName, lastName);
    }

    private void generatePassword() {
        password = PasswordGenerator.generatePassword();
    }
}
