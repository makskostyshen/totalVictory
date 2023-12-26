package com.makskostyshen.web.controller;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.exception.CaseNotFoundException;
import com.makskostyshen.web.WebLayerMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.views.rocker.RockerWritable;
import lombok.RequiredArgsConstructor;

@Controller("/cases/delete")
@RequiredArgsConstructor
public class CaseDeleteController {
    private final CaseRepository repository;

    @Get("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> get(@PathVariable final String id) {
        CaseEntity caseEntity = repository.findById(id).orElseThrow(CaseNotFoundException::new);
        return HttpResponse.ok(
                new RockerWritable(
                        views.caseConfirmDelete.template(
                                WebLayerMapper.I.mapToDetails(caseEntity))
                )
        );
    }

    @Post("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> post(@PathVariable final String id) {
        repository.deleteById(id);
        return HttpResponse.seeOther(UriBuilder.of("/cases").build());
    }
}
