package com.makskostyshen.data.impl;

import com.makskostyshen.data.entity.CaseEntity;
import com.makskostyshen.exception.CSVReadException;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Singleton
public class CSVWriter {

    @Property(name = "app.cases.fileName")
    private String fileName;

    public void write(final List<CaseEntity> cases) {

        try {
            Writer writer = new FileWriter(fileName);
            StatefulBeanToCsv<CaseCsvModel> beanToCsv = new StatefulBeanToCsvBuilder<CaseCsvModel>(writer).build();
            beanToCsv.write(cases.stream().map(DataLayerMapper.I::map).toList());
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            throw new CSVReadException(e);
        }
    }
}
