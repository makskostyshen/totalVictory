package com.makskostyshen.web.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Serdeable

public class CaseDetailsDto {
    private String id;

    private String client;

    private String opponent;

    private String price;

    private String subject;

    private String number;

    private String judge;

    private String doneWork;

    private String currentStage;

    private String currentStageDeadlineDate;

    private String currentStageDeadlineTime;

    private String orderStatus;

    private String note;
}
