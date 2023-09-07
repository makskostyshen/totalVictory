package com.makskostyshen.web;


import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.web.dto.CaseListingResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public abstract class WebLayerMapper {
    public static WebLayerMapper I = Mappers.getMapper(WebLayerMapper.class);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public abstract CaseListingResponseDto map(final CaseEntity entity);

    protected String map(final LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}
