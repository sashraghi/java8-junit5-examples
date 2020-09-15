package com.company.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamWithCsv {

    @Test
    public void streamRowsFromCsv() throws IOException {
        Stream<String> rows1 = Files.lines(Paths.get("src/test/resources/data.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();

    }

    @Test
    public void streamRowsParseDataFromRows() throws IOException {
        Stream<String> rows2 = Files.lines(Paths.get("src/test/resources/data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();
    }

    @Test
    public void streamRowsStoreFieldsHashmap() throws IOException {
        Stream<String> rows3 = Files.lines(Paths.get("src/test/resources/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }
    }

    @Test
    public void streamReduction() {
        double total1 = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total1 = " + total1);

        double total2 = Stream.of(7.3, 1.5, 4.8).reduce(0.0, Double::sum);
        System.out.println("Total2 = " + total2);
    }

    @Test
    public void streamSummaryStatistics() {
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
    }

}
