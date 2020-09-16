package com.company.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {

        assertThat(MessageService.get()).isEqualTo("Hello JUnit 5");
    }

    @Test
    public void testFunctions() {
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");

        Function<String, Integer> nameMappingFunction = String::length;

        final List<Integer> integers = names.stream().map(nameMappingFunction).collect(Collectors.toList());

        assertThat(integers.size() == 5).isTrue();
        assertThat(integers.get(4)).isEqualTo(7);

        System.out.println(integers);
    }
}
