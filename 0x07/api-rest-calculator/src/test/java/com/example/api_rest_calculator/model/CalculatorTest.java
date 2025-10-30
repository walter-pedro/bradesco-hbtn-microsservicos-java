package com.example.api_rest_calculator.model;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        assertEquals(2.0, calculator.sum(1.0, 1.0));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(1.0, null));
    }

    @Test
    void subTest() {
        assertEquals(1.0, calculator.sub(2.0, 1.0));
    }

    @Test
    void divideTest() {
        assertEquals(2.0, calculator.divide(4.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1010, calculator.integerToBinary(10));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("a", calculator.integerToHexadecimal(10));
    }

    @Test
    void calculeDayBetweenDateTest() {
        assertEquals(10, calculator.calculeDayBetweenDate(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 11)));
    }
}
