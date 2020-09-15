package com.company.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    @Test
    public void streamOfSortedAndFindFirst() {
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void streamFromArraySortFilterPrint() {
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)    // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void averageOfSquares() {
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(x -> x * x)
			.average()
			.ifPresent(System.out::println);
    }

    @Test
    public void streamFromListFilterAndPrint(){
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }
}
