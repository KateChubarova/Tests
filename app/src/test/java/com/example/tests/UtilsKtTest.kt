package com.example.tests

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class UtilsKtTest {

    @Test
    fun stringToInteger() {
        assertEquals(2, com.example.tests.utils.stringToInteger("2"));
        assertEquals(-2, com.example.tests.utils.stringToInteger("-2"));
        assertEquals(0, com.example.tests.utils.stringToInteger(""));
        assertEquals(0, com.example.tests.utils.stringToInteger("a"));

        assertNull(null)
    }
}