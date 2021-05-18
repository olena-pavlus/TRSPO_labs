package com.pavlus.lab3.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "forester_tb")
public class Forester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foresterID;
    private String fullName;
    private String phoneNumber;
    private String email;

}
