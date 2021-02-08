package com.vortexbird.junit.junit_pitest_mutations.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

	@Test
    public void testPositive() {

        CalculatorService obj = new CalculatorService();
        assertEquals(true, obj.isPositive(10));

    }

}
