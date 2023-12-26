package com.makskostyshen.web;

import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.web.dto.CaseDetailsDto;
import com.makskostyshen.web.dto.CaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Mapper
public abstract class WebLayerMapper {
    public static WebLayerMapper I = Mappers.getMapper(WebLayerMapper.class);

    private final String EMPTY_FIELD_VALUE = "...";

    private final DateTimeFormatter dateTimeDisplayFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm");
    private final DateTimeFormatter dateDisplayFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final DateTimeFormatter standardSystemDateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private final DateTimeFormatter standardSystemTimeFormatter = DateTimeFormatter.ISO_TIME;

    @Mapping(
            target = "currentStageDeadline",
            expression = "java(mapDeadline(entity.getCurrentStageDeadlineDate(), entity.getCurrentStageDeadlineTime()))")
    public abstract CaseDto map(final CaseEntity entity);

    public abstract CaseEntity map(final CaseDetailsDto detailsDto);

    protected LocalDate mapToLocalDate(final String dateValue) {
        if (dateValue == null || dateValue.isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateValue, standardSystemDateFormatter);
    }

    protected LocalTime mapToLocalTime(final String timeValue) {
        if (timeValue == null || timeValue.isEmpty()) {
            return null;
        }
        return LocalTime.parse(timeValue, standardSystemTimeFormatter);
    }

    protected String mapDeadline(final LocalDate date, final LocalTime time) {
        if (date == null) {
            return EMPTY_FIELD_VALUE;
        } else if (time == null) {
            return dateDisplayFormatter.format(date);
        } else {
            return dateTimeDisplayFormatter.format(LocalDateTime.of(date, time));
        }
    }

    protected String map(final String stringField) {
        if (stringField.isEmpty()) {
            return EMPTY_FIELD_VALUE;
        }
        return stringField;
    }

}
