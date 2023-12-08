package com.makskostyshen.web.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Serdeable

public class CaseDetailsDto {
    private String client;

    private String opponent;

    private String subject;

    private String number;

    private String judge;

    private String doneWork;

    private String currentStage;

    private String deadlineDate;

    private String deadlineTime;

    private String note;
}
