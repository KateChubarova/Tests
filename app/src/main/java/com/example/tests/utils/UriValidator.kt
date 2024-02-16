package com.example.tests.utils

import android.content.Context
import com.example.tests.R
import java.net.URI


class UriValidator(private val context: Context) {

    fun validate(uri: String): String {
        var resId: Int = R.string.nothing
        if (isUrl(uri)) {
            resId = R.string.url
        } else if (isFile(uri)) {
            resId = R.string.file
        }
        return context.getString(resId)
    }

    private fun isUrl(uri: String): Boolean =
        "http" == URI.create(uri).scheme

    private fun isFile(uri: String): Boolean =
        "file" == URI.create(uri).scheme
}