package org.example.model;

import lombok.*;
import org.apache.logging.log4j.core.Logger;
import org.example.util.PasswordGenerator;
import org.example.util.UsernameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected String firstName;
    protected String lastName;
    protected String username;
    private String password;
    private Boolean isActive;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = PasswordGenerator.generatePassword();
    }


}
