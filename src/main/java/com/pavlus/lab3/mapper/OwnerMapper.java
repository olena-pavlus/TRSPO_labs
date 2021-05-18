package com.pavlus.lab3.mapper;

import com.pavlus.lab3.model.Owner;
import com.pavlus.lab3.model.dto.OwnerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    OwnerDTO toDTO(Owner owner);

    Owner toOwner(OwnerDTO ownerDTO);

    List<OwnerDTO> ownerToOwnerDTOs(List<Owner> owners);

    List<Owner> ownerDTOToOwners(List<OwnerDTO> ownerDTOS);

}
