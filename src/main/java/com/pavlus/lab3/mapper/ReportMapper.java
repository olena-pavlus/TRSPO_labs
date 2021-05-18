package com.pavlus.lab3.mapper;

import com.pavlus.lab3.model.Owner;
import com.pavlus.lab3.model.Report;
import com.pavlus.lab3.model.dto.OwnerDTO;
import com.pavlus.lab3.model.dto.ReportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportDTO toDTO(Report report);

    Report toReport(ReportDTO reportDTO);

    List<ReportDTO> reportToReportDTOs(List<Report> reports);

    List<Report> reportDTOToReports(List<ReportDTO> reportDTOS);

}
