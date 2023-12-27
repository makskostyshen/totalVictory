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

@Controller("/cases/create")
@RequiredArgsConstructor
public class CasesCreationController {
    private final CaseRepository repository;

    @Get
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> get() {
        return HttpResponse.ok(new RockerWritable(views.cases.caseCreate.template()));
    }

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> post(@Body final CaseDetailsDto caseDetailsDto) {
        repository.save(WebLayerMapper.I.map(caseDetailsDto));
        return HttpResponse.seeOther(UriBuilder.of(CasesListingController.PATH).build());
    }
}
