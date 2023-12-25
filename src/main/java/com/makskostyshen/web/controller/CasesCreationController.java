package com.makskostyshen.web.controller;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.web.WebLayerMapper;
import com.makskostyshen.web.dto.CaseDetailsDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.views.rocker.RockerWritable;
import lombok.RequiredArgsConstructor;

@Controller("/cases/new")
@RequiredArgsConstructor
public class CasesCreationController {
    private final CaseRepository caseRepository;

    @Get
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> get() {
        return HttpResponse.ok(new RockerWritable(views.caseCreation.template()));
    }

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> createCase(@Body CaseDetailsDto caseDetailsDto) {
        caseRepository.save(WebLayerMapper.I.map(caseDetailsDto));
        return HttpResponse.seeOther(UriBuilder.of("/cases").build());
    }
}
