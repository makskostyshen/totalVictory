package com.makskostyshen.data.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CaseEntity {
    private String id;

    private String client;

    private String opponent;

    private String subject;

    private String price;

    private String number;

    private String judge;

    private String doneWork;

    private String currentStage;

    private LocalDate currentStageDeadlineDate;

    private LocalTime currentStageDeadlineTime;

    private String execution;

    private String note;
}
