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
@Table(name = "report_tb")
public class Report {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reportCode;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(foreignKey = @ForeignKey(name = "foresterID"), name = "foresterID")
//    @JsonIgnoreProperties(value = {"instruction_tb", "hibernateLazyInitializer"})
//    private Forester forester;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "instructionCode"), name = "instructionCode")
    @JsonIgnoreProperties(value = {"instruction_tb", "hibernateLazyInitializer"})
    private Instruction instruction;

    private boolean approval;

}
