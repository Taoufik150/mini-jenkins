package com.mini;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addition() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void multiplication() {
        assertEquals(12, calc.multiply(3, 4));
    }
}
