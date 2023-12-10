package com.makskostyshen.web.controllers;

import com.makskostyshen.web.dto.CaseListingResponseDto;
import io.micronaut.http.annotation.*;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.views.rocker.RockerWritable;
import io.micronaut.http.HttpResponse;
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

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> createCase(@Body CaseListingResponseDto request) {
        // Виконайте валідацію та інші операції створення справи
        // Виведіть справу у консоль або збережіть у базі даних

        System.out.println("Creating case: " + request);

        // Після створення перенаправте користувача на сторінку списку справ
        return HttpResponse.seeOther(UriBuilder.of("/cases").build());
    }
}
