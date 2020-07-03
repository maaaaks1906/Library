package com.maks.library.database.repository;

import com.maks.library.database.model.AbstractModel;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Repository<T extends AbstractModel> {

    private String csvPath;
    private Class<T> clazz;

    public Repository(String csvPath, Class<T> clazz) {
        this.csvPath = csvPath;
        this.clazz = clazz;
    }

    public T save(T t) {

        List<T> currentModels = findAll();
        t.setId(currentModels.size() + 1);
        currentModels.add(t);

        try (Writer writer = new FileWriter(csvPath)){

            StatefulBeanToCsv<T> sbt = new StatefulBeanToCsvBuilder<T>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            sbt.write(currentModels);

            writer.flush();
            writer.close();

        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

        return t;
    }

    public List<T> findAll() {
        try (Reader reader = new FileReader(csvPath)) {

            CsvToBean<T> csv = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csv.parse();

        } catch (FileNotFoundException ignored) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public Optional<T> findById(int id) {
        return findAll().stream().filter(model -> model.getId() == id).findFirst();
    }

    public void deleteAll() {
        File file = new File(csvPath);
        file.delete();
    }
}
