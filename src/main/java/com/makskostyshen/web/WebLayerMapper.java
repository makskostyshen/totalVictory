package com.makskostyshen.web;


import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.web.dto.CaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Mapper
public abstract class WebLayerMapper {
    public static WebLayerMapper I = Mappers.getMapper(WebLayerMapper.class);

    private final String EMPTY_FIELD_VALUE = "...";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public abstract CaseDto map(final CaseEntity entity);

    protected String map(final LocalDateTime dateTime) {
        if (Objects.isNull(dateTime)) {
            return EMPTY_FIELD_VALUE;
        }
        return dateTime.format(formatter);
    }

    protected String map(final String stringField) {
        if (stringField.isEmpty()) {
            return EMPTY_FIELD_VALUE;
        }
        return stringField;
    }

}
