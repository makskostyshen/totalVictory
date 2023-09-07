package com.makskostyshen.data.impl;

import com.makskostyshen.data.entity.CaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public abstract class DataLayerMapper {

    public static final DataLayerMapper I = Mappers.getMapper(DataLayerMapper.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public abstract CaseEntity map(final CaseCsvModel csvModel);

    protected LocalDateTime mapToLocalDateTime(final String dateTimeValue) {
        return LocalDateTime.parse(dateTimeValue, formatter);
    }
}
