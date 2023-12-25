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
    public abstract CaseCsvModel map(final CaseEntity caseEntity);

    protected LocalDateTime mapToLocalDateTime(final String dateTimeValue) {
        if (dateTimeValue == null || dateTimeValue.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateTimeValue, formatter);
    }

    protected String mapLocalDateTime(final LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(formatter);
    }
}
