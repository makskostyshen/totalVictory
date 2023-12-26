package com.makskostyshen.data.api;

import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.data.impl.CSVReader;
import com.makskostyshen.data.impl.CSVWriter;
import com.makskostyshen.data.impl.CaseRepositoryImpl;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(propertySources = {"application.properties"})
class CaseRepositoryTest {

    @Inject
    private CaseRepository repository;

    @Inject
    private CSVWriter writer;

    @Property(name = "app.cases.init.fileName")
    private String initFileName;

    private void loadInitCases() {
        CSVReader initReader = new CSVReader();
        initReader.setFileName(initFileName);
        CaseRepository initRepository = new CaseRepositoryImpl(
                initReader,
                null
        );
        List<CaseEntity> initCases = initRepository.findAll();
        writer.write(initCases);
    }

    @Test
    void shouldSaveCaseWithNoDateAndTimeInTheEnd() {
        //given
        loadInitCases();
        CaseEntity caseEntity = CaseEntity.builder()
                .id("6")
                .build();

        //when
        repository.save(caseEntity);

        //then
        List<CaseEntity> cases = repository.findAll();
        assertEquals(cases.size(), 6);
        assertEquals(cases.get(0).getId(), "1");
        assertEquals(cases.get(1).getId(), "2");
        assertEquals(cases.get(2).getId(), "3");
        assertEquals(cases.get(3).getId(), "4");
        assertEquals(cases.get(4).getId(), "5");
        assertEquals(cases.get(5).getId(), "6");
    }

    @Test
    void shouldSaveCaseWithNoDateBeforeCasesWithNoDateAndTime() {
        //given
        loadInitCases();
        CaseEntity caseEntity = CaseEntity.builder()
                .id("6")
                .currentStageDeadlineTime(LocalTime.of(12, 40))
                .build();

        //when
        repository.save(caseEntity);

        //then
        List<CaseEntity> cases = repository.findAll();
        assertEquals(cases.size(), 6);
        assertEquals(cases.get(0).getId(), "1");
        assertEquals(cases.get(1).getId(), "2");
        assertEquals(cases.get(2).getId(), "3");
        assertEquals(cases.get(3).getId(), "4");
        assertEquals(cases.get(4).getId(), "6");
        assertEquals(cases.get(5).getId(), "5");
    }

    @Test
    void shouldSaveCaseWithSmallestDateInTheBeginning() {
        //given
        loadInitCases();
        CaseEntity caseEntity = CaseEntity.builder()
                .id("6")
                .currentStageDeadlineDate(LocalDate.of(2023, 9, 18))
                .build();

        //when
        repository.save(caseEntity);

        //then
        List<CaseEntity> cases = repository.findAll();
        assertEquals(cases.size(), 6);
        assertEquals(cases.get(0).getId(), "6");
        assertEquals(cases.get(1).getId(), "1");
        assertEquals(cases.get(2).getId(), "2");
        assertEquals(cases.get(3).getId(), "3");
        assertEquals(cases.get(4).getId(), "4");
        assertEquals(cases.get(5).getId(), "5");
    }

    @Test
    void shouldSaveCaseWithRepeatingDateButDifferentTimeCorrectly() {
        //given
        loadInitCases();
        CaseEntity caseEntity = CaseEntity.builder()
                .id("6")
                .currentStageDeadlineDate(LocalDate.of(2023, 12, 1))
                .currentStageDeadlineTime(LocalTime.of(13, 30))
                .build();

        //when
        repository.save(caseEntity);

        //then
        List<CaseEntity> cases = repository.findAll();
        assertEquals(cases.size(), 6);
        assertEquals(cases.get(0).getId(), "1");
        assertEquals(cases.get(1).getId(), "2");
        assertEquals(cases.get(2).getId(), "3");
        assertEquals(cases.get(3).getId(), "6");
        assertEquals(cases.get(4).getId(), "4");
        assertEquals(cases.get(5).getId(), "5");
    }
}