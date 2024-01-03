package com.makskostyshen.web.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.uri.UriBuilder;
import lombok.RequiredArgsConstructor;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @Get
    @Produces(TEXT_HTML)
    public HttpResponse<?> get() {
        return HttpResponse.seeOther(UriBuilder.of(CasesListingController.PATH).build());
    }
}
