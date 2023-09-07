package com.makskostyshen.data.api;

import com.makskostyshen.data.entity.CaseEntity;

import java.util.List;

public interface CaseRepository {
    List<CaseEntity> findAll();
}
