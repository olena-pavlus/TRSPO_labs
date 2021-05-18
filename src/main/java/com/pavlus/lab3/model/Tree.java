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
@Table(name = "tree_tb")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String name;

}
