package com.makskostyshen.event;

import com.makskostyshen.backup.BackupService;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ApplicationStartupEventListener implements ApplicationEventListener<StartupEvent> {
    private final BackupService backupService;

    @Override
    public void onApplicationEvent(final StartupEvent event) {
        backupService.updateBackup();
    }
}
