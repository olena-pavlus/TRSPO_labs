package com.pavlus.lab3.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InstructionDTO {

    private int instructionCode;

    private OwnerDTO owner;

    private ForesterDTO forester;

    private TreeDTO tree;

    private String operation;

}
