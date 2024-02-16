package com.example.tests

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class MyRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        println(
            String.format(
                "com.example.tests.MyRule apply, description: class = %s, method = %s",
                description.testClass.simpleName,
                description.methodName
            )
        )
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                println("MyRule statement, before evaluate")
                base.evaluate()
                println("MyRule statement, after evaluate")
            }
        }
    }

}