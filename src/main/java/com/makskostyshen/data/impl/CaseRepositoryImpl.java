package com.makskostyshen.data.impl;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.data.entity.CaseEntity;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CaseRepositoryImpl implements CaseRepository {

    private final CSVReader reader;

    @Override
    public List<CaseEntity> findAll() {
        return reader.read().stream()
                .map(DataLayerMapper.I::map)
                .toList();
    }
}
