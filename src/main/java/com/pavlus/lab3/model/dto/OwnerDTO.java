package com.pavlus.lab3.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OwnerDTO {

    private int ownerID;
    private String fullName;
    private String phoneNumber;
    private String email;

}
