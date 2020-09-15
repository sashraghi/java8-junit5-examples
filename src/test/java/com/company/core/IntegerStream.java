package com.company.core;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class IntegerStream {

    @Test
    public void integerStream() {
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();

    }

    @Test
    public void integerStreamWithSkip() {
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
    }


    @Test
    public void integerStreamWithSum() {
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        System.out.println();
    }

}
