package com.company.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {

    @Test
    public void testPredicateLength() {
        final List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameLength = str -> {
            return str.length() > 5;
        };
        names.stream().filter(nameLength).forEach(System.out::println);
    }

    @Test
    public void testPredicateStartWith() {
        final List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartWithS).forEach(System.out::println);
    }

    @Test
    public void testPredicateAndComposition() {
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;

        names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);


    }

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", MessageService.get());
    }
}
