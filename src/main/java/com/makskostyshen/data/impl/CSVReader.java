package com.makskostyshen.data.impl;

import com.makskostyshen.exception.CSVReadException;
import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Singleton
public class CSVReader {

    @Property(name = "app.cases.fileName")
    private String fileName;

    public List<CaseCsvModel> read() {
        try {
            return new CsvToBeanBuilder<CaseCsvModel>(
                    new FileReader(fileName, StandardCharsets.UTF_8))
                    .withType(CaseCsvModel.class).build().parse();
        } catch (IOException e) {
            throw new CSVReadException(e);
        }
    }
}
