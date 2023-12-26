package com.makskostyshen.data.api;

import com.makskostyshen.data.entity.CaseEntity;

import java.util.List;
import java.util.Optional;

public interface CaseRepository {
    List<CaseEntity> findAll();

    void save(CaseEntity caseEntity);

    Optional<CaseEntity> findById(String id);
}
