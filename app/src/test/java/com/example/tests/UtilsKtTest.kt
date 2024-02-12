package com.example.tests

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsKtTest {

    @Test
    fun stringToInteger() {
        assertEquals(2, stringToInteger("2"));
        assertEquals(-2, stringToInteger("-2"));
        assertEquals(0, stringToInteger(""));
        assertEquals(0, stringToInteger("a"));
    }
}