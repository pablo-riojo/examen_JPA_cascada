package com.JPA.cascade.bill.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {
    BillMapper Instance = Mappers.getMapper(BillMapper.class);

    BillOutputDTO billToBillOutputDTO(Bill bill);
    Bill billInputDTOtoBill(BillInputDTO billInputDTO);
}
