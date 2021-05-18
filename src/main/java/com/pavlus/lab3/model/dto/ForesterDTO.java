package com.pavlus.lab3.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ForesterDTO {

    private int foresterID;
    private String fullName;
    private String phoneNumber;
    private String email;

}
