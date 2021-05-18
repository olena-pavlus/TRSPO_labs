package com.pavlus.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "instruction_tb")
public class Instruction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int instructionCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "ownerID"), name = "ownerID")
    @JsonIgnoreProperties(value = {"instruction_tb", "hibernateLazyInitializer"})
    private Owner owner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "foresterID"), name = "foresterID")
    @JsonIgnoreProperties(value = {"instruction_tb", "hibernateLazyInitializer"})
    private Forester forester;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "number"), name = "number")
    @JsonIgnoreProperties(value = {"instruction_tb", "hibernateLazyInitializer"})
    private Tree tree;

    private String operation;

}
