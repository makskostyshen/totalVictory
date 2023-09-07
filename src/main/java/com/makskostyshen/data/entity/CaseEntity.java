package com.makskostyshen.data.entity;

import lombok.*;

import java.time.LocalDateTime;

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

    private String number;

    private String judge;

    private String doneWork;

    private String currentStage;

    private LocalDateTime currentStageDeadline;

    private String note;
}
