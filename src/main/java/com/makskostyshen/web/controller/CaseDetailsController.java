package com.makskostyshen.web.controller;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.web.dto.CaseDetailsDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.views.rocker.RockerWritable;
import lombok.RequiredArgsConstructor;

@Controller("/cases/details")
@RequiredArgsConstructor
public class CaseDetailsController {
    private final CaseRepository repository;
    @Get("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> get(@PathVariable final String id) {
        System.out.println("id is " + id);
        return HttpResponse.ok(new RockerWritable(views.caseDetails.template(CaseDetailsDto.builder().build())));
    }

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> post(@Body CaseDetailsDto caseDetailsDto) {
        System.out.println("id is " + caseDetailsDto.getId());
        return HttpResponse.seeOther(UriBuilder.of("/cases").build());
    }
}
