package com.makskostyshen.web;

import com.makskostyshen.exception.UpdateBackupException;
import com.makskostyshen.web.controller.ErrorController;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Singleton
public class GlobalExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse<?>> {
    private final HttpResponse<?> defaultResponse =
            HttpResponse.seeOther(UriBuilder.of(ErrorController.ERROR_PATH).build());
    private final Map<Class<?>, HttpResponse<?>> exceptionResponseRegistry = Map.of(
            UpdateBackupException.class,
            HttpResponse.seeOther(UriBuilder.of(ErrorController.BACKUP_UPDATE_ERROR_PATH).build())
    );
    @Override
    public HttpResponse<?> handle(final HttpRequest request, final RuntimeException exception) {
        log.error("Error occurred", exception);

        HttpResponse<?> response = exceptionResponseRegistry.get(exception.getClass());

        return response != null
                ? response
                : defaultResponse;
    }
}
