package com.pavlus.lab3.mapper;

import com.pavlus.lab3.model.Tree;
import com.pavlus.lab3.model.dto.TreeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TreeMapper {

    TreeMapper INSTANCE = Mappers.getMapper(TreeMapper.class);

    TreeDTO toDTO(Tree tree);

    Tree toTree(TreeDTO treeDTO);

    List<TreeDTO> treeToTreeDTOs(List<Tree> trees);

    List<Tree> treeDTOToTrees(List<TreeDTO> treeDTOS);

}
