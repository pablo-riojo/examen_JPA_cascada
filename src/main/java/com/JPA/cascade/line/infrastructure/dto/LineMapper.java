package com.JPA.cascade.line.infrastructure.dto;

import com.JPA.cascade.line.domain.Line;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LineMapper {
    LineMapper Instance = Mappers.getMapper(LineMapper.class);

    LineOutputDTO lineToLineOutputDTO(Line line);
    Line lineInputDTOtoLine(LineInputDTO lineInputDTO);
}
