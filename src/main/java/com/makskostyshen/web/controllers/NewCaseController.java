package com.makskostyshen.web.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.rocker.RockerWritable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;
import lombok.RequiredArgsConstructor;

@Controller("/cases/new")
@RequiredArgsConstructor
public class NewCaseController {

    @Get
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> get() {
        return HttpResponse.ok(new RockerWritable(views.newCase.template()));
    }
}
