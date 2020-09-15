package com.company.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", MessageService.get());
    }

    @Test
    public void testFunctions() {
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");

        Function<String, Integer> nameMappingFunction = String::length;

        final List<Integer> integers = names.stream().map(nameMappingFunction).collect(Collectors.toList());

        System.out.println(integers);
    }
}
