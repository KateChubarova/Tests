package com.example.tests

import com.example.tests.utils.Calculator
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    @Before
    fun setUp() {
        println("\r\nsetUp");
    }

    @After
    fun tearDown(){
        println("tearDown");
    }

    @Test
    fun add() {
        println("add");
        assertEquals(9, Calculator.add(6,3));
    }

    @Test
    fun subtract() {
        println("subtract");
        assertEquals(3, Calculator.subtract(6,3));
    }

    @Test
    fun multiply() {
        println("multiply");
        assertEquals(18, Calculator.multiply(6,3));
    }

    @Test
    fun divide() {
        println("divide");
        assertEquals(2, Calculator.divide(6,3));
    }
}