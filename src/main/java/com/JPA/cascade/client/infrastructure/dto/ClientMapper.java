package com.JPA.cascade.client.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper Instance = Mappers.getMapper(ClientMapper.class);

    ClientOutputDTO billToBillOutputDTO(Bill bill);
    Bill billInputDTOtoBill(ClientInputDTO clientInputDTO);
}
