package com.makskostyshen.data.impl;

import com.makskostyshen.data.api.CaseRepository;
import com.makskostyshen.data.entity.CaseEntity;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
@RequiredArgsConstructor
public class CaseRepositoryImpl implements CaseRepository {

    private final CSVReader reader;

    private final CSVWriter writer;
    @Override
    public List<CaseEntity> findAll() {
        return getAllEntitiesStream()
                .sorted(Comparator.comparing(CaseEntity::getCurrentStageDeadline, Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }

    @Override
    public void save(final CaseEntity caseEntity) {
        if (caseEntity.getId() == null) {
            saveNewCase(caseEntity);
        } else {
            saveUpdatedCase(caseEntity);
        }
    }

    private void saveNewCase(final CaseEntity caseEntity) {
        List<CaseEntity> allCases = getAllEntitiesStream().collect(Collectors.toCollection(ArrayList::new));
        caseEntity.setId(UUID.randomUUID().toString());
        allCases.add(caseEntity);
        writer.write(allCases);
    }

    private void saveUpdatedCase(final CaseEntity caseEntity) {
        List<CaseEntity> sameIdCases = new ArrayList<>();
        List<CaseEntity> differentIdCases = new ArrayList<>();

        getAllEntitiesStream().forEach(entity -> {
            if (entity.getId().equals(caseEntity.getId())) {
                sameIdCases.add(entity);
            } else {
                differentIdCases.add(entity);
            }
        });

        if (sameIdCases.size() != 1) {
            throw new RuntimeException();
        }

        differentIdCases.add(caseEntity);
        writer.write(differentIdCases);
    }

    private Stream<CaseEntity> getAllEntitiesStream() {
        return reader.read().stream().map(DataLayerMapper.I::map);
    }
}
