package com.nisha.assertions;

import com.nisha.junit_demo.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AaaPatternTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up calculator instance");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down calculator instance");
    }

    @Test
    void testAddition() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}
