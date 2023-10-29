package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {
    @Test
    @Disabled("Do not run it until we finish something else")
    void basicTest() {

    }

    @Test
    @EnabledOnOs({OS.MAC,OS.LINUX})
    void testOnlyForMacOSAndLinux() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10, max = JRE.JAVA_17)
    void testRunOnJreRange() {

    }
}
