package com.luv2code.tdd;

import com.luv2code.tdd.FizzBuzz;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {
    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree() {
        // fail("fail");
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.computer(3), "should return Fizz when divisible only by 3");
    }

    @Test
    @DisplayName("Divisible by Five")
    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.computer(5), "should return buzz when divisible only by 5");
    }

    @Test
    @DisplayName("Divisible by Three And Five")
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.computer(15), "shoul return FizzBuzz when divisible by both 3 and 5");
    }

    @Test
    @DisplayName("Divisible by Three And Five")
    void testNotForDivisibleByThreeNorFive() {
        String expected = "1";
        assertEquals(expected, FizzBuzz.computer(1), "should return 1 when divisible by neither 3 nor 5");
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "15,FizzBuzz"
    })
    @Order(4)
    void testWithParameterized(int value, String expected) {
        assertEquals(expected, FizzBuzz.computer(value));
    }

    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = {"/csv-data.csv"})
    // @CsvFileSource(files = {"csv-data.csv"}, delimiterString = " ") // Does not work
    void testWithCsvFileSource(int value, String expected) {
        assertEquals(expected,FizzBuzz.computer(value));
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/medium-test-data.csv"})
    void testWithMediumCsvFileSources(int value, String expected) {
        assertEquals(expected,FizzBuzz.computer(value));
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/large-test-data.csv"})
    void testWithLargeCsvFileSources(int value, String expected) {
        assertEquals(expected,FizzBuzz.computer(value));
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = {"/large-test-data.csv", "/medium-test-data.csv"})
    void testWithMultiCsvFileSources(int value, String expected) {
        assertEquals(expected,FizzBuzz.computer(value));
    }
}
