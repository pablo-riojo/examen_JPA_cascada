package com.JPA.cascade.header.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.header.domain.Header;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HeaderMapper {
    HeaderMapper Instance = Mappers.getMapper(HeaderMapper.class);

    HeaderOutputDTO headerToHeaderOutputDTO(Header header);
}
