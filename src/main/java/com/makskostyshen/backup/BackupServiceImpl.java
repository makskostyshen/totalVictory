package com.makskostyshen.backup;

import com.makskostyshen.exception.UpdateBackupException;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Slf4j
@Singleton
public class BackupServiceImpl implements BackupService {
    @Property(name = "app.cases.fileName")
    private String originFileName;

    @Property(name = "app.cases.backup.fileName")
    private String backupFileName;

    @Property(name = "app.cases.backup.max-update-attempts", defaultValue = "1")
    private Integer maxUpdateBackupAttempts;

    @Override
    public void updateBackup() {
        int errorsCount = 0;

        while (true) {
            try {
                copyFileContents(originFileName, backupFileName);
                break;
            } catch (final IOException e) {
                if (errorsCount > 0 && errorsCount < maxUpdateBackupAttempts) {
                    log.warn("Backup file have not been updated", e);
                    errorsCount++;
                }
                if (errorsCount < maxUpdateBackupAttempts) {
                    errorsCount++;
                } else {
                    throw new UpdateBackupException(e);
                }
            }
        }
    }

    private void copyFileContents(final String sourcePath, final String destinationPath) throws IOException {
        Files.copy(
                Path.of(sourcePath),
                Path.of(destinationPath),
                StandardCopyOption.REPLACE_EXISTING);
    }
}
