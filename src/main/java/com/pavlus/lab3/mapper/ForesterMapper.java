package com.pavlus.lab3.mapper;

import com.pavlus.lab3.model.Forester;
import com.pavlus.lab3.model.dto.ForesterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ForesterMapper {

    ForesterMapper INSTANCE = Mappers.getMapper(ForesterMapper.class);

    ForesterDTO toDTO(Forester forester);

    Forester toForester(ForesterDTO foresterDTO);

    List<ForesterDTO> foresterToForesterDTOs(List<Forester> foresters);

    List<Forester> foresterDTOToForesters(List<ForesterDTO> foresterDTOS);

}
