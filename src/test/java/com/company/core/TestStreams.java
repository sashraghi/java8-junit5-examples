package com.company.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {

    @Test
    public void streamRowsFromTextFileSortFilterAndPrint() throws IOException {

        Stream<String> bands = Files.lines(Paths.get("src/test/resources/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();
    }

    @Test
    public void streamRowsFromTextFileAndSaveToList() throws IOException {
        List<String> bands2 = Files.lines(Paths.get("src/test/resources/bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());

        bands2.forEach(x -> System.out.println(x));
    }
}
