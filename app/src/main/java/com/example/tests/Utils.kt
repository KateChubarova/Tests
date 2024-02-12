package com.example.tests

fun stringToInteger(s: String): Int {
    return try {
        s.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        0
    }
}