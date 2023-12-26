package com.makskostyshen.data.impl;

import com.makskostyshen.data.entity.CaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Mapper
public abstract class DataLayerMapper {

    public static final DataLayerMapper I = Mappers.getMapper(DataLayerMapper.class);
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public abstract CaseEntity map(final CaseCsvModel csvModel);
    public abstract CaseCsvModel map(final CaseEntity caseEntity);

    protected LocalDate mapToLocalDate(final String dateValue) {
        if (dateValue == null || dateValue.isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateValue, dateFormatter);
    }

    protected LocalTime mapToLocalTime(final String timeValue) {
        if (timeValue == null || timeValue.isEmpty()) {
            return null;
        }
        return LocalTime.parse(timeValue, timeFormatter);
    }

    protected String mapLocalDate(final LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(dateFormatter);
    }

    protected String mapLocalTime(final LocalTime time) {
        if (time == null) {
            return null;
        }
        return time.format(timeFormatter);
    }
}
