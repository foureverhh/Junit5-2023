package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.DisplayName.class)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) works with @order(int) lowest number has highest priority
public class DemoUtilsTest {
    private DemoUtils utils;

    @BeforeEach
    void setup() {
        utils = new DemoUtils();
    }

    @Test
   // @DisplayName("testAdd")
    void testEqualsAndNotEquals() {
        assertEquals(6, utils.add(2,4), "2 + 4 should equals 6");
        assertNotEquals(9, utils.add(1,9), "1 + 9 should not equals 6");
    }

    @Test
   // @DisplayName("test checkNull")
    void testNullAndNotNull() {
        String str1 = null;
        String str2 = "luvCode2";
        assertNull(utils.checkNull(str1));
        assertNotNull(utils.checkNull(str2));

    }

    @Test
    void testSameAndNotSame() {
        assertSame(utils.getAcademy(), utils.getAcademyDuplicate(), "Should be the same String object");
        String str1 = new String("Luv2Code Academy");
        String str2 = "Luv2Code Academy";
        assertNotSame(str1, str2, "Should not be the same String object");
        assertSame(str1.intern(), str2, "Should not be the same String object");
    }
    @Test
    @DisplayName("test assertArrayEquals() deep equals")
    void testArrayIsEqual() {
        String[] array = new String[]{"A", "B", "C"};
        assertArrayEquals(array, utils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    @DisplayName("test assertIterableEquals() deep equals")
    void testIterableEqual() {
        List<String> list = List.of("luv","2","code");
        assertIterableEquals(list, utils.getAcademyInList(), "assertIterableEquals()");
    }

    @Test
    @DisplayName("test assertIterableEquals() deep equals")
    void testLinesMatch() {
        List<String> list1 = List.of("luv","2","code");
        assertLinesMatch(list1, utils.getAcademyInList(), "assertIterableEquals()");
        List<String> list2 = List.of("luv","2","code");
        assertLinesMatch(list1, list2); //linesMatch specially for list String
        assertIterableEquals(list1, list2);

 /*       List<String> expected = Arrays.asList("Line 1", "Line 2", "Line 3");
        List<String> actual = Arrays.asList("  Line 1  ", "Line 2", "Line 3");
        assertLinesMatch(expected, actual);*/

    }

    @Test
    void testAssertThrows() {
        assertThrows(Exception.class, ()->utils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> utils.throwException(9));
    }

    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> utils.checkTimeout(), "should done in 1 second");
        // assertTimeout(Duration.ofSeconds(3), () -> utils.checkTimeout(), "should done in 2 seconds");
    }

    @Test
    void testTimeout() {
        // assertTimeoutPreemptively(Duration.ofSeconds(23), () -> utils.checkTimeout(), "should done in 1 second");
        assertTimeout(Duration.ofSeconds(3), () -> utils.checkTimeout(), "should done in 2 seconds");
    }
}
