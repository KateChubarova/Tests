package com.example.tests.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tests.R
import com.example.tests.utils.Converter
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun changeTextCorrect() {
        val text = "my test text"
        onView(withId(R.id.editText)).perform(typeText(text));
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(text)))
        onView(withId(R.id.textView)).check(matches(withTagValue(`is`(100))))
    }

    @Test
    @Throws(Exception::class)
    fun changeTextEmpty() {
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(R.string.empty_text)))
    }

    @Test(expected = NumberFormatException::class)
    @Throws(java.lang.Exception::class)
    fun test() {
        Converter.stringToInteger("a")
    }
}
