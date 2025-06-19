package org.example.thread_coordination.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class ComplexCalculationTest {
    @Test
    public void testExercise() throws Exception {
        ComplexCalculation complexCalculation = new ComplexCalculation();

        BigInteger base1 = new BigInteger("3");
        BigInteger power1 = new BigInteger("10");
        BigInteger base2 = new BigInteger("2");
        BigInteger power2 = new BigInteger("6");

        BigInteger expectedResult = base1.pow(power1.intValue()).add(base2.pow(power2.intValue()));

        BigInteger actualResult = complexCalculation.calculateResult(base1, power1, base2, power2);

        Assertions.assertEquals(expectedResult, actualResult, "The result of the calculation is incorrect");
    }
}
