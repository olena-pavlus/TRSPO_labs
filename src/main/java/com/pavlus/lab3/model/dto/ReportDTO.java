package com.pavlus.lab3.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReportDTO {

    private int reportCode;

    private InstructionDTO instruction;

    private boolean approval;

}
