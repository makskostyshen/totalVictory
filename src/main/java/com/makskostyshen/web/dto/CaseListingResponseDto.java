package com.makskostyshen.web.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CaseListingResponseDto {
    private String client;

    private String opponent;

    private String subject;

    private String number;

    private String judge;

    private String doneWork;

    private String currentStage;

    private String currentStageDeadline;

    private String note;
}
