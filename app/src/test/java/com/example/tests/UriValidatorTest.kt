package com.example.tests

import android.content.Context
import com.example.tests.utils.UriValidator

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UriValidatorTest{
    private lateinit var uriValidator: UriValidator

    @Mock
    private lateinit var mockContext: Context

    companion object {
        const val NOTHING = "Nothing"
        const val URL = "URL"
        const val FILE = "File"
    }

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        Mockito.`when`(mockContext.getString(R.string.nothing)).thenReturn("Nothing")
        Mockito.`when`(mockContext.getString(R.string.url)).thenReturn("URL")
        Mockito.`when`(mockContext.getString(R.string.file)).thenReturn("File")

        uriValidator = UriValidator(mockContext)
    }

    @Test
    fun validate() {
        MatcherAssert.assertThat(uriValidator.validate("http://google.com"), CoreMatchers.`is`(URL))
        MatcherAssert.assertThat(
            uriValidator.validate("file://sdcard/DCIM/img001.jpg"),
            CoreMatchers.`is`(FILE)
        )
        MatcherAssert.assertThat(uriValidator.validate("bla-bla-bla"), CoreMatchers.`is`(NOTHING))
    }

}