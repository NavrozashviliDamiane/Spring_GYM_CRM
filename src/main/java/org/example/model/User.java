package org.example.model;

import lombok.*;

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
    protected String password;
    private Boolean isActive;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
