package com.makskostyshen.web.controller;

import com.makskostyshen.exception.UpdateBackupException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.views.rocker.RockerWritable;
import lombok.RequiredArgsConstructor;

import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller
@RequiredArgsConstructor
public class ErrorController {

    public static final String ERROR_PATH = "/error";
    public static final String BACKUP_UPDATE_ERROR_PATH = ERROR_PATH + "/backup/update";
    @Get(ERROR_PATH)
    @Produces(TEXT_HTML)
    public HttpResponse<?> get() {
        return HttpResponse.ok(new RockerWritable(views.errors.error.template()));
    }

    @Get(BACKUP_UPDATE_ERROR_PATH)
    @Produces(TEXT_HTML)
    public HttpResponse<?> getBackupUpdateErrorPage() {
        return HttpResponse.ok(new RockerWritable(views.errors.errorUpdateBackup.template()));
    }
}
