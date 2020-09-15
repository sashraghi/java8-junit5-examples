package com.company.core;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class SupplierTest {


    @Test
    public void supplierWithOptional() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        Optional<Double> optionalDouble = Optional.empty();
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }
}
