package com.pavlus.lab3.mapper;

import com.pavlus.lab3.model.Instruction;
import com.pavlus.lab3.model.dto.InstructionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InstructionMapper {

    InstructionMapper INSTANCE = Mappers.getMapper(InstructionMapper.class);

    InstructionDTO toDTO(Instruction instruction);

    Instruction toInstruction(InstructionDTO instructionDTO);

    List<InstructionDTO> instructionToInstructionDTOs(List<Instruction> instructions);

    List<Instruction> instructionDTOToInstructions(List<InstructionDTO> instructionDTOS);

}
