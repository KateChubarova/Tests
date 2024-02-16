package com.example.tests


import com.example.tests.utils.Converter
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ConverterTest {

    @JvmField
    @Rule
    var myRule = MyRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        println("setUp")
    }

    @Test
    fun stringToInteger() {
        println("parseNumbersToInteger")
        assertEquals(1, Converter.stringToInteger("1"))
        assertEquals(-1, Converter.stringToInteger("-1"))
    }

    @Test
    fun stringToInteger2() {
        println("parseNumbersToInteger2")
        assertEquals(1, Converter.stringToInteger("1"))
        assertEquals(-1, Converter.stringToInteger("-1"))
    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
        println("tearDown")
    }

}