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

}
