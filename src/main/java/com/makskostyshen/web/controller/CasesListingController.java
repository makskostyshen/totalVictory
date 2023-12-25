package com.makskostyshen.web.controller;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.web.WebLayerMapper;
import com.makskostyshen.web.dto.CaseDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.rocker.RockerWritable;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller("/cases")
@RequiredArgsConstructor
public class CasesListingController {

    private final CaseRepository repository;
    @Get
    @Produces(TEXT_HTML)
    public HttpResponse<?> get() {
        List<CaseDto> cases = repository.findAll()
                .stream()
                .map(WebLayerMapper.I::map)
                .toList();

        return HttpResponse.ok(new RockerWritable(views.casesListing.template(cases)));
    }
}
