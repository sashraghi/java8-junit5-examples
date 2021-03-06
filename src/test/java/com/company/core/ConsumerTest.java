package com.company.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", MessageService.get());
    }

    @DisplayName("test names presented in the list")
    @Test
    public void whenNamesPresentConsumeAll() {
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);
    }

    @DisplayName("test names present use both consumer")
    @Test
    public void whenNamesPresentUseBothConsumer() {
        List<String> listOfCities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };

        Consumer<List<String>> printConsumerList = list ->{
          list.stream().forEach(System.out::println);
        };
        upperCaseConsumer.andThen(printConsumerList).accept(listOfCities);
    }
}
