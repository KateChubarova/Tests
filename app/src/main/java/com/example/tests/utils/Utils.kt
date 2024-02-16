package com.example.tests.utils

fun stringToInteger(s: String): Int {
    return try {
        s.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        0
    }
}