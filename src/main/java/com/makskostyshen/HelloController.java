package com.makskostyshen;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.rocker.RockerWritable;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller() // (1)

public class HelloController {

    @Get
    @Produces(TEXT_HTML)// (2)
    public HttpResponse<?> index() {
        return HttpResponse.ok(new RockerWritable(views.home.template("tt"))); // (3)
    }
}
