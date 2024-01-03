package com.makskostyshen.data.impl;

import com.makskostyshen.exception.CSVWriteException;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Singleton
public class CSVWriter {

    @Property(name = "app.cases.fileName")
    private String fileName;

    public void write(final List<CaseCsvModel> cases) {

        try {
            Writer writer = new FileWriter(fileName, StandardCharsets.UTF_8);
            StatefulBeanToCsv<CaseCsvModel> beanToCsv = new StatefulBeanToCsvBuilder<CaseCsvModel>(writer).build();
            beanToCsv.write(cases);
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            throw new CSVWriteException(e);
        }
    }
}
